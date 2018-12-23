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

package com.s2u2m.iam.controller;

import com.s2u2m.iam.config.security.constant.LoginStrategyConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController create on 2018/12/23
 *
 * @author Amos Xia
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "Hello";
    }

    @GetMapping(LoginStrategyConstant.USERNAME_PASSWORD)
    public String usernamePasswordLogin() {
        return "Username Password login";
    }
}