package com.qaxpert.models;

import java.util.List;

public class AppMetadata {
    private String provider;
    private List<String> providers;

    public AppMetadata(){

    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public List<String> getProviders() {
        return providers;
    }

    public void setProviders(List<String> providers) {
        this.providers = providers;
    }
}
