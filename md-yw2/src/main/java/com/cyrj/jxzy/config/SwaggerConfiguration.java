package com.cyrj.jxzy.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lzf
 * @Date 2021-07-15 10:17
 * @Version 1.0.0
 */
@Configuration
@EnableSwagger2WebMvc
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {


    @Bean
    public Docket restApi() {
        //schema
        List<GrantType> grantTypes=new ArrayList<>();
        //密码模式
        String passwordTokenUrl="http://localhost:30006/yz/oauth/token";
//        String passwordTokenUrl="http://localhost:30006/yz/oauth/token?username=macro&password=123456&grant_type=password&client_id=client-app&client_secret=123456";
        ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant=new ResourceOwnerPasswordCredentialsGrant(passwordTokenUrl);
        grantTypes.add(resourceOwnerPasswordCredentialsGrant);
        OAuth oAuth=new OAuthBuilder().name("oauth2")
                .grantTypes(grantTypes).build();
        //context
        //scope方位
        List<AuthorizationScope> scopes=new ArrayList<>();
        scopes.add(new AuthorizationScope("read","read  resources"));
        scopes.add(new AuthorizationScope("write","write resources"));
        scopes.add(new AuthorizationScope("reads","read all resources"));
        scopes.add(new AuthorizationScope("writes","write all resources"));

        SecurityReference securityReference=new SecurityReference("oauth2",scopes.toArray(new AuthorizationScope[]{}));
        SecurityContext securityContext=new SecurityContext(Lists.newArrayList(securityReference),PathSelectors.ant("/**"));
        //schemas
        List<SecurityScheme> securitySchemes= Lists.newArrayList(oAuth);
        //securyContext
        List<SecurityContext> securityContexts= Lists.newArrayList(securityContext);
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cyrj.jxzy.Controller.Constractor"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts)
                .securitySchemes(securitySchemes)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("功能测试")
                .description("<div style='font-size:14px;color:red;'>承包商管理、地址接口</div>")
                .termsOfServiceUrl("https://www.sydx.com")
                .contact(new Contact("采油软件中心", "https://www.sydx.com/cyrj", "750257@qq.com"))
                .license("Open Source")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();
    }
}
