/*
 *    Copyright [2019] [s2u2m]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.s2u2m.iam.config;

import com.s2u2m.iam.IamServerApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.LinkedList;
import java.util.List;

/**
 * SwaggerConfig create on 19-2-12.
 *
 * @author Amos Xia
 */
@Configuration
@EnableSwagger2
@Profile(value = {"dev"})
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts());
    }

//    @Bean
//    public SecurityConfiguration security() {
//        return SecurityConfigurationBuilder.builder()
//                .useBasicAuthenticationWithAccessCodeGrant(false)
//                .build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(IamServerApplication.class.getSimpleName())
                .build();
    }

    private List<SecurityScheme> securitySchemes() {
        var schemes = new LinkedList<SecurityScheme>();
        var httpBasicScheme = new BasicAuth("basic");
        schemes.add(httpBasicScheme);
        return schemes;
    }

    private List<SecurityContext> securityContexts() {
        var contexts = new LinkedList<SecurityContext>();
        return contexts;
    }

}
