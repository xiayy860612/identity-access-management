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

package com.s2u2m.iam.config.security.username;

import com.s2u2m.iam.constant.LoginStrategyConstant;
import org.springframework.beans.factory.annotation.Autowired;
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

        @Autowired
        private UsernameUserDetailServiceImpl usernameUserDetailServiceImpl;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            final String[] permitAllUrls = new String[] {
                    "**/regist"
            };
            http.antMatcher(LoginStrategyConstant.USERNAME)
                    // TODO: enable csrf after fix csrf token issue
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers(permitAllUrls).permitAll()
                    .anyRequest().authenticated()
                    .and()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                    .and()
                    .httpBasic();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(usernameUserDetailServiceImpl);
        }
    }
}
