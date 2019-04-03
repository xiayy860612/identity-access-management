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

package com.s2u2m.iam.error.exception;

import com.s2u2m.iam.error.AccountErrorEnum;
import com.s2u2m.iam.error.BaseIamException;
import com.s2u2m.iam.error.ErrorBuilder;

/**
 * @author Amos Xia
 */
public final class AccountExistedException extends BaseIamException {
    private static final int code = ErrorBuilder.build(AccountErrorEnum.ACCOUNT_EXISTED);

    protected AccountExistedException(String msg) {
        super(code, msg);
    }

    protected AccountExistedException(Throwable cause, String msg) {
        super(code, msg, cause);
    }
}
