package com.example.checkout;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "features")
public class FeatureFlags {

    private boolean newCheckout;

    public boolean isNewCheckout()             { return newCheckout; }
    public void    setNewCheckout(boolean v)   { this.newCheckout = v; }
}
