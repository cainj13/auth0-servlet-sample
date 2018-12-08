package com.auth0.example;

import com.auth0.AuthenticationController;
import com.auth0.jwk.UrlJwkProvider;

import javax.servlet.ServletConfig;
import java.io.UnsupportedEncodingException;

public abstract class AuthenticationControllerProvider {

    public static AuthenticationController getInstance(ServletConfig config) throws UnsupportedEncodingException {
        String domain = config.getServletContext().getInitParameter("com.auth0.domain");
        String clientId = config.getServletContext().getInitParameter("com.auth0.clientId");
        String clientSecret = config.getServletContext().getInitParameter("com.auth0.clientSecret");

        return AuthenticationController.newBuilder(domain, clientId, clientSecret)
                .withResponseType("id_token")
                // https://jcain.auth0.com/.well-known/openid-configuration
                .withJwkProvider(new UrlJwkProvider(String.format("https://%s/", domain)))
                .build();
    }
}
