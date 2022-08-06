package com.sydx.wg.authorization;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 鉴权管理器，用于判断是否有资源的访问权限
 * Created by macro on 2020/6/19.
 */
@Component
@AllArgsConstructor
@Slf4j
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        ServerHttpResponse response = authorizationContext.getExchange().getResponse();
        String path = request.getURI().getPath();
//        oauth/authorize?code
        System.out.println(request.getURI().getPath());
        //对于挂接的地址请求，直接验证加密后放行
//        if (path.equals("/yz/oauth/authorize")) {
//            return Mono.just(new AuthorizationDecision(true));
//        }
        // 可能存在的跨域预检请求放行
        if (request.getMethod() == HttpMethod.OPTIONS) {
            return Mono.just(new AuthorizationDecision(true));
        }

        //从Redis中获取当前路径可访问角色列表

        String token = request.getHeaders().getFirst("Authorization");
        // Restful接口权限设计 @link https://www.cnblogs.com/haoxianrui/p/14396990.html
        String restfulPath = request.getMethodValue() + ":" + path;
        System.out.println("请求方法:RESTFul请求路径：{}"+ restfulPath);

        //当前路径的权限
//        Object obj = redisTemplate.opsForHash().get(RedisConstant.RESOURCE_ROLES_MAP, path);
//        System.out.println("-----------1_鉴权管理器+path="+path+"[]"+obj);
//        权限列表
//        List<String> authorities = Convert.toList(String.class,obj);
//        authorities = authorities.stream().map(i -> i = AuthConstant.AUTHORITY_PREFIX + i).collect(Collectors.toList());
//        System.out.println("-----------1_鉴权管理器+map="+authorities.toString());
        //认证通过且角色匹配的用户可访问当前路径
        return mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authority -> {return true;})
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
    }

}
