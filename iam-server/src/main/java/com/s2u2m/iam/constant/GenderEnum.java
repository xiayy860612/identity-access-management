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

package com.s2u2m.iam.constant;

/**
 * GenderEnum create on 19-2-17.
 *
 * @author Amos Xia
 */
@SuppressWarnings("ALL")
public enum GenderEnum implements IIntEnum<GenderEnum> {
    UNKNONW(0),
    MALE(1),
    FEMALE(2),
    ;

    private final int value;
    GenderEnum(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return this.value;
    }}
