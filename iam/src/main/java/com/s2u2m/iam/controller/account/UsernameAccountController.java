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

package com.s2u2m.iam.controller.account;

import com.s2u2m.iam.domain.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * UsernameAccountController create on 2018/11/4
 *
 * @author Amos Xia
 */
@RestController
@RequestMapping("/account/username")
public class UsernameAccountController {

    @PostMapping("")
    public ResponseEntity register(@RequestBody UsernameAccountRegDTO regInfo) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<String> login() {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return ResponseEntity.ok(userInfo.getNickName());
    }

}
