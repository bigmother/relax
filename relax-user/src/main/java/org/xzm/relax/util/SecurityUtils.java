package org.xzm.relax.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import net.minidev.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.xzm.relax.constant.Constant;
import org.xzm.relax.model.dto.TokenDTO;
/**
 * 认证权限相关工具
 *
 * @author Administrator
 */
public class SecurityUtils {

    private SecurityUtils() {
    }

    private static RSAKey rsaJWK;
    private static JWSSigner signer;

    static {
        try {
            rsaJWK = new RSAKeyGenerator(2048)
                    .keyID(Constant.JWT_SECRET)
                    .generate();
            signer = new RSASSASigner(rsaJWK);
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取当前用户id
     *
     * @return 用户id
     */
    public static String getUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    /**
     * 获取token
     * @return tokenDTO
     */
    public static TokenDTO getToken() throws JOSEException {
        TokenDTO tokenDTO = new TokenDTO();
        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build();
        JSONObject data = new JSONObject();
        //一天过期
        data.put("userId",getUserId());
        data.put("expiredDate",System.currentTimeMillis()+1000*60*60*24);
        JWSObject jwsObject = new JWSObject(header, new Payload(data));
        jwsObject.sign(signer);
        tokenDTO.setToken(jwsObject.serialize());

        JSONObject refreshData = new JSONObject();
        //10天过期
        refreshData.put("userId",getUserId());
        refreshData.put("expiredDate",System.currentTimeMillis()+1000*60*60*24*10);
        jwsObject = new JWSObject(header,new Payload(refreshData));
        jwsObject.sign(signer);
        tokenDTO.setRefreshToken(jwsObject.serialize());
        return tokenDTO;
    }
}
