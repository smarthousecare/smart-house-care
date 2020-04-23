/*
 * Copyright 2017 by Brisa Inovação e Tecnologia S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Brisa, SA ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Brisa.
 */
package com.house.care.config.client.domain;

import java.io.Serializable;
import java.util.List;

/**
 * <class description>
 *
 */
public class ClientAuthKeys implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6503993088246942738L;

    private List<Key> keys;

    /**
     * Empty Constructor
     */
    public ClientAuthKeys() {

        // Empty Constructor
    }

    public List<Key> getKeys() {

        return keys;
    }

    public void setKeys(List<Key> keys) {

        this.keys = keys;
    }

}
