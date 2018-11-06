/*
 * Copyright 2018 s2u2m
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.s2u2m.iam.auth;

import com.s2u2m.iam.dao.authentication.UsernameAuthDAO;
import com.s2u2m.iam.dao.user.UserDAO;
import com.s2u2m.iam.domain.UserInfo;
import com.s2u2m.iam.domain.account.UsernameAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Objects;

/**
 * UsernameAuthenticationProvider create on 2018/11/6
 *
 * @author Amos Xia
 */
@Component
public class UsernameAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsernameAuthDAO usernameAuthDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        UsernameAccount account = usernameAuthDAO.get(token.getName());
        if (Objects.isNull(account)) {
            String error = MessageFormat.format("Account[{0}] not existed", token.getName());
            throw new UsernameNotFoundException(error);
        }

        String pwd = (String) token.getCredentials();
        if (!account.getPassword().equals(pwd)) {
            String error = MessageFormat.format("Account[{0}] password error", token.getName());
            throw new BadCredentialsException(error);
        }

        UserInfo userInfo = userDAO.get(account.getUserId());
        Collection<? extends GrantedAuthority> authorities = usernameAuthDAO.getAuthorities(userInfo);
        return new UsernamePasswordAuthenticationToken(userInfo, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(aClass);
    }

}
