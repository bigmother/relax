package org.xzm.relax.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import net.minidev.json.JSONObject;
import org.xzm.relax.constant.Constant;
import org.xzm.relax.model.dto.TokenDTO;

import java.text.ParseException;

/**
 * @author xuzhemin
 * 2019/4/1
 */
public class TokenUtils {
    private TokenUtils(){}

    private static RSAKey rsaJWK;
    private static JWSSigner signer;
    private static RSAKey rsaPublicJWK;
    static {
        try {
            rsaJWK = new RSAKeyGenerator(2048)
                    .keyID(Constant.JWT_SECRET)
                    .generate();
            signer = new RSASSASigner(rsaJWK);
            rsaPublicJWK = rsaJWK.toPublicJWK();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取token
     * @return tokenDTO
     */
    public static TokenDTO getToken(Long userId) throws JOSEException {
        TokenDTO tokenDTO = new TokenDTO();
        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build();
        JSONObject data = new JSONObject();
        //一天过期
        data.put("userId",userId);
        data.put("expiredDate",System.currentTimeMillis()+1000*60*60*24);
        JWSObject jwsObject = new JWSObject(header, new Payload(data));
        jwsObject.sign(signer);
        tokenDTO.setToken(jwsObject.serialize());

        JSONObject refreshData = new JSONObject();
        //10天过期
        refreshData.put("userId",userId);
        refreshData.put("expiredDate",System.currentTimeMillis()+1000*60*60*24*10);
        jwsObject = new JWSObject(header,new Payload(refreshData));
        jwsObject.sign(signer);
        tokenDTO.setRefreshToken(jwsObject.serialize());
        return tokenDTO;
    }


    public static Long getUserId(String token){
        JWSObject jwsObject;
        JWSVerifier verifier;
        try {
            jwsObject = JWSObject.parse(token);
            verifier = new RSASSAVerifier(rsaPublicJWK);
            if (!jwsObject.verify(verifier)){
                return null;
            }
            return (Long)jwsObject.getPayload().toJSONObject().get("userId");
        } catch (ParseException|JOSEException e) {
            e.printStackTrace();
        }
        return null;
    }
}
