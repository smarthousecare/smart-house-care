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

/**
 * <class description>
 *
 */
public class Key implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8386081673079134420L;

    private String kty;

    private String e;

    private String use;

    private String kid;

    private String alg;

    private String n;

    /**
     * Default Key Constructor.
     */
    public Key() {

        // Default empty constructor
    }

    public String getKty() {

        return kty;
    }

    public void setKty(String kty) {

        this.kty = kty;
    }

    public String getE() {

        return e;
    }

    public void setE(String e) {

        this.e = e;
    }

    public String getUse() {

        return use;
    }

    public void setUse(String use) {

        this.use = use;
    }

    public String getKid() {

        return kid;
    }

    public void setKid(String kid) {

        this.kid = kid;
    }

    public String getAlg() {

        return alg;
    }

    public void setAlg(String alg) {

        this.alg = alg;
    }

    public String getN() {

        return n;
    }

    public void setN(String n) {

        this.n = n;
    }

}
