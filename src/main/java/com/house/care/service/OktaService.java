package com.house.care.service;

import java.time.Instant;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.house.care.service.dto.AuthenticationTokenDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OktaService {

    public static final String CLIENT_CREDENTIALS = "client_credentials";

    private static final String SCOPE = "access";

    @Autowired
    private ClientCredentialsResourceDetails clientCredentialsResourceDetails;

    @Autowired
    private OAuth2AuthorizedClientService clientService;

    public AuthenticationTokenDTO authenticateOkta() {

        RestTemplate restTemplate = ServiceUtils.getLoggingBasicAuthenticationRestTemplate();

        // create form parameters as a MultiValueMap
        MultiValueMap<String, String> formVars = new LinkedMultiValueMap<>();
        formVars.add(OAuth2ParameterNames.GRANT_TYPE, CLIENT_CREDENTIALS);
        formVars.add(OAuth2ParameterNames.CLIENT_ID, clientCredentialsResourceDetails.getClientId());
        formVars.add(OAuth2ParameterNames.CLIENT_SECRET, clientCredentialsResourceDetails.getClientSecret());
        formVars.add(OAuth2ParameterNames.SCOPE, SCOPE);

        AuthenticationTokenDTO authenticationToken = restTemplate.postForObject(clientCredentialsResourceDetails.getAccessTokenUri(), formVars,
                AuthenticationTokenDTO.class);
        log.trace("AUTHENTICATION TOKEN = {}", authenticationToken);
        return authenticationToken;
    }

    public String getCurrentAuthenticationToken() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(
                oauthToken.getAuthorizedClientRegistrationId(),
                oauthToken.getName());

        OAuth2AccessToken accessToken = client.getAccessToken();
        if (accessToken == null || Instant.now().isBefore(Objects.requireNonNull(accessToken.getExpiresAt()))) {
            AuthenticationTokenDTO authenticationTokenDTO = authenticateOkta();
            return authenticationTokenDTO.getAccessToken();
        }
        else {
            return accessToken.getTokenValue();
        }
    }
}
