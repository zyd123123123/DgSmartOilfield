package com.sydx.oauth2.controller;

import com.sydx.common.utils.JwtUtils;
import com.sydx.oauth2.api.CommonResult;
import com.sydx.oauth2.dao.CommonDaoI;
import com.sydx.oauth2.domain.Oauth2TokenDto;
import com.sydx.oauth2.domain.UserDTO;
import com.sydx.oauth2.entity.KeyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.Principal;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 自定义Oauth2获取令牌接口
 * Created by macro on 2020/7/17.
 */
@RestController
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;
    @Autowired
    private CommonDaoI dao;
    /**
     * Oauth2登录认证
     */

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public Object postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        String clientId = JwtUtils.getAuthClientId();
        if(clientId.equals("client-jump")){
            UserDTO userDTO = new UserDTO();
            try {
                //解密用户信息     【时间戳|油田代码|用户名】
                KeyEntity keyEntity = (KeyEntity) dao.obj("getKey",userDTO);
                String mingwen = decrypt2(parameters.get("username"), keyEntity.getPublickey());
                String list[] = mingwen.split("\\|");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                long riqi = formatter.parse(list[0]).getTime();
                long currentdate = new Date().getTime();
                System.out.println("时间："+list[0]);
                System.out.println("油田："+list[1]);
                System.out.println("用户："+list[2]);
                System.out.println(currentdate - riqi);
                if (currentdate - riqi <= 120000) {
                    parameters.put("username",list[2]+","+list[1]);
                } else {
                    System.out.println("user error or timeout...");
                    return CommonResult.failed("user error or timeout...");
                }
                parameters.put("username","admin,pc0dq");
            } catch (Exception e) {
                System.out.println("code error...");
                return CommonResult.failed("code error...");
            }
        }else if(clientId.equals("client-api")){
            parameters.put("username",parameters.get("username")+",pc0cq");
            //接口文档专用，格式可以自动回填 调试认证 lzf
            return tokenEndpoint.postAccessToken(principal, parameters).getBody();
        }else{
            parameters.put("username",parameters.get("username"));
        }
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .access_token(oAuth2AccessToken.getValue())
                .refresh_token(oAuth2AccessToken.getRefreshToken().getValue())
                .expires_in(oAuth2AccessToken.getExpiresIn())
                .token_type("bearer").build();
        return CommonResult.success(oauth2TokenDto);
    }

    public static String decrypt2(String str, String privateKey) throws Exception {
        //因为url传参时会将+号替换成空格，所以在加密传参时须将+号替换
        //或者如是加密时不替换这里可以 处理空格str = str.replace(" ", "+");
        str = str.replace("|A|", "+");

        //64位解码加密后的字符串
        byte[] inputByte = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(str.getBytes("UTF-8"));

        //base64编码的私钥
        byte[] decoded = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }
}
