package com.auth0.example;

import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * Prints string values formatted pretty
 */
public interface PrettyJWT extends DecodedJWT {

    String prettyHeader();

    String prettyPayload();
}
