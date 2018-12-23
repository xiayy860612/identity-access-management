/*
 *    Copyright [2018] [s2u2m]
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

package com.s2u2m.iam.config.security;

import com.s2u2m.iam.config.security.constant.LoginStrategyConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * UsernameLoginConfig create on 2018/12/23
 *
 * @author Amos Xia
 */
@Configuration
public class UsernameLoginConfig {

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            // TODO: use jdbc instead
            auth.inMemoryAuthentication()
                    .withUser("test").password("123456").authorities("USER");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            final String permitAllUrls = LoginStrategyConstant.USERNAME_PASSWORD + "/**";
            http.antMatcher(LoginStrategyConstant.USERNAME_PASSWORD)
                    .authorizeRequests()
                    .antMatchers(permitAllUrls).permitAll()
                    .anyRequest().authenticated();
        }
    }
}
