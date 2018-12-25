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

import com.s2u2m.iam.domain.UserEntity;
import com.s2u2m.iam.domain.account.UsernameAccountEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * UsernameUserDetailServiceImpl create on 2018/12/25
 *
 * @author Amos Xia
 */
@Component
class UsernameUserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = UserEntity.builder()
                .id("1")
                .nickName("test")
                .password("123456").build();
        UsernameAccountEntity account = UsernameAccountEntity.builder()
                .username("test")
                .user(user)
                .build();
        return new UsernameUserDetails(account);
    }
}
