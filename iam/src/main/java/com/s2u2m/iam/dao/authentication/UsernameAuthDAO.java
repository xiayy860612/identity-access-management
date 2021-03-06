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

package com.s2u2m.iam.dao.authentication;

import com.s2u2m.iam.domain.UserInfo;
import com.s2u2m.iam.domain.account.UsernameAccount;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * UsernameAuthDAO create on 2018/11/6
 *
 * @author Amos Xia
 */
public interface UsernameAuthDAO {

    UsernameAccount get(String username);

    Collection<? extends GrantedAuthority> getAuthorities(UserInfo userInfo);
}
