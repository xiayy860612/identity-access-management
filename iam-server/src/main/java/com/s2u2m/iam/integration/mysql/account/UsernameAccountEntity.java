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

package com.s2u2m.iam.integration.mysql.account;

import lombok.Getter;
import lombok.Setter;

/**
 * UsernameAccountEntity create on 19-2-17.
 *
 * @author Amos Xia
 */
@Getter
@Setter
public final class UsernameAccountEntity extends BaseAccountEntity {
    private String username;
}
