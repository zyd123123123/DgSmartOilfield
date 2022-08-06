package com.sydx.oauth2.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Oauth2获取Token返回信息封装
 * Created by macro on 2020/7/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Oauth2TokenDto {
    /**
     * 访问令牌
     */
    private String access_token;
    /**
     * 刷新令牌
     */
    private String refresh_token;
    /**
     * 访问令牌头前缀
     */
    private String token_type;
    /**
     * 有效时间（秒）
     */
    private int expires_in;
}
