/*
 *    Copyright [2018-2019] [s2u2m]
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

package com.s2u2m.iam.controller.account;

import com.s2u2m.iam.domain.User;
import com.s2u2m.iam.domain.account.UsernameAccount;
import com.s2u2m.iam.error.AccountErrorEnum;
import com.s2u2m.iam.error.ExceptionBuilder;
import com.s2u2m.iam.error.exception.AccountExistedException;
import com.s2u2m.iam.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/username-accounts")
public class UsernameAccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/")
    public ResponseEntity register(@RequestBody UsernameAccountRegisterInfoDTO info) {
        if (accountRepository.isUsernameAccountExisted(info.getUsername())) {
            ExceptionBuilder.runtimeException(AccountErrorEnum.ACCOUNT_EXISTED,
                    "Account[{0}] already existed", info.getUsername());
        }

        User newUser = User.builder()
                .nickName(info.getUsername())
                .birthday(Instant.EPOCH)
                .password(info.getPassword())
                .gender(info.getGender())
                .build();
        UsernameAccount newAccount = UsernameAccount.builder()
                .username(info.getUsername())
                .user(newUser)
                .build();
        try {
            accountRepository.registerUsernameAccount(newAccount);
        } catch (AccountExistedException e) {
            ExceptionBuilder.runtimeException(e);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
