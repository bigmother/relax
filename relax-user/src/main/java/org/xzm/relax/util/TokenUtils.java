package org.xzm.relax.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import org.xzm.relax.model.dto.TokenDTO;

/**
 * @author xuzhemin
 * 2019/3/27
 */
public class TokenUtils {

    public static TokenDTO generateToken(){
//        RSAKey rsaJWK = new RSAKeyGenerator(2048)
//                .keyID("123")
//                .generate();
//        RSAKey rsaPublicJWK = rsaJWK.toPublicJWK();
//
//        // Create RSA-signer with the private key
//        JWSSigner signer = new RSASSASigner(rsaJWK);
//
//        // Prepare JWS object with simple string as payload
//        JWSObject jwsObject = new JWSObject(
//                new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build(),
//                new Payload("In RSA we trust!"));
//
//// Compute the RSA signature
//        jwsObject.sign(signer);
//
//        // To serialize to compact form, produces something like
//// eyJhbGciOiJSUzI1NiJ9.SW4gUlNBIHdlIHRydXN0IQ.IRMQENi4nJyp4er2L
//// mZq3ivwoAjqa1uUkSBKFIX7ATndFF5ivnt-m8uApHO4kfIFOrW7w2Ezmlg3Qd
//// maXlS9DhN0nUk_hGI3amEjkKd0BWYCB8vfUbUv0XGjQip78AI4z1PrFRNidm7
//// -jPDm5Iq0SZnjKjCNS5Q15fokXZc8u0A
//        String s = jwsObject.serialize();
        return null;
    }

}
