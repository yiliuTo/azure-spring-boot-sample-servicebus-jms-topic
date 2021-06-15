package com.azure.spring.sample.jms.topic;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -295422703255886286L;
    private String name;

    User(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
