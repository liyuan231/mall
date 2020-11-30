package com.liyuan.component.jwt;

import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import java.util.Set;

public class JwtTokenGenerator {
    private JwtPayloadBuilder jwtPayloadBuilder;
    private JwtProperties jwtProperties;
    private KeyPair keyPair;

    public JwtTokenGenerator(JwtPayloadBuilder jwtPayloadBuilder, JwtProperties jwtProperties) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, KeyStoreException, InvalidKeySpecException {
        this.jwtPayloadBuilder = jwtPayloadBuilder;
        this.jwtProperties = jwtProperties;
        KeyPairFactory keyPairFactory = new KeyPairFactory();
        this.keyPair = keyPairFactory.create(jwtProperties.getKeyLocation(), jwtProperties.getKeyAlias(), jwtProperties.getKeyPass());
    }

    public JwtTokenPair jwtTokenPair(String audience, Set<String> roles, Map<String, String> additional) {
        String accessToken = this.jwtToken(audience, jwtProperties.getTokenExpirationDays(), roles, additional);
        String refreshToken = this.jwtToken(audience, jwtProperties.getRefreshTokenExpirationDays(), roles, additional);
        return new JwtTokenPair(accessToken, refreshToken);
    }

    private String jwtToken(String audience, int expirationDays, Set<String> roles, Map<String, String> additional) {
        String payload = jwtPayloadBuilder
                .audience(audience)
                .roles(roles)
                .additional(additional)
                .issuer(jwtProperties.getIssuer())
                .subscriber(jwtProperties.getSubscriber())
                .expirationDays(expirationDays)
                .build();
        PrivateKey aPrivate = this.keyPair.getPrivate();
        RsaSigner signer = new RsaSigner((RSAPrivateKey) aPrivate);
        return JwtHelper.encode(payload, signer).getEncoded();
    }

    public String decodeAndVerify(String jwtToken) {
        PublicKey aPublic = this.keyPair.getPublic();
        SignatureVerifier signatureVerifier = new RsaVerifier((RSAPublicKey) aPublic);
        Jwt jwt = JwtHelper.decodeAndVerify(jwtToken, signatureVerifier);
        return jwt.getClaims();
    }

    public JwtTokenPair jwtTokenPairWithUsername(String username, Set<String> roles, Map<String, String> additional) {
        return jwtTokenPair(username, roles, additional);
    }
}
