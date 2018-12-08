package com.auth0.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cedarsoftware.util.io.JsonWriter;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JsonIoPrettyJwt implements PrettyJWT {

    private final DecodedJWT decodedJWT;

    public JsonIoPrettyJwt(final String jwt) {
        decodedJWT = JWT.decode(jwt);
    }

    @Override
    public String prettyHeader() {
        return JsonWriter.formatJson(new String(Base64.getDecoder().decode(this.getHeader())));
    }

    @Override
    public String prettyPayload() {
        return JsonWriter.formatJson(new String(Base64.getDecoder().decode(this.getPayload())));
    }

    @Override
    public String getToken() {
        return decodedJWT.getToken();
    }

    @Override
    public String getHeader() {
        return decodedJWT.getHeader();
    }

    @Override
    public String getPayload() {
        return decodedJWT.getPayload();
    }

    @Override
    public String getSignature() {
        return decodedJWT.getSignature();
    }

    @Override
    public String getIssuer() {
        return decodedJWT.getIssuer();
    }

    @Override
    public String getSubject() {
        return decodedJWT.getSubject();
    }

    @Override
    public List<String> getAudience() {
        return decodedJWT.getAudience();
    }

    @Override
    public Date getExpiresAt() {
        return decodedJWT.getExpiresAt();
    }

    @Override
    public Date getNotBefore() {
        return decodedJWT.getNotBefore();
    }

    @Override
    public Date getIssuedAt() {
        return decodedJWT.getIssuedAt();
    }

    @Override
    public String getId() {
        return decodedJWT.getId();
    }

    @Override
    public Claim getClaim(String name) {
        return decodedJWT.getClaim(name);
    }

    @Override
    public Map<String, Claim> getClaims() {
        return decodedJWT.getClaims();
    }

    @Override
    public String getAlgorithm() {
        return decodedJWT.getAlgorithm();
    }

    @Override
    public String getType() {
        return decodedJWT.getType();
    }

    @Override
    public String getContentType() {
        return decodedJWT.getContentType();
    }

    @Override
    public String getKeyId() {
        return decodedJWT.getKeyId();
    }

    @Override
    public Claim getHeaderClaim(String name) {
        return decodedJWT.getHeaderClaim(name);
    }
}
