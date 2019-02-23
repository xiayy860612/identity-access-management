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

package com.s2u2m.iam.integration.mysql;

import com.s2u2m.iam.constant.GenderEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

import static org.junit.Assert.assertEquals;

/**
 * UserMapperTest create on 19-2-19.
 *
 * @author Amos Xia
 */
public class UserMapperTest extends BaseMySqlTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void createSuccess() throws NoSuchAlgorithmException {
        UserEntity entity = new UserEntity();
        entity.setId("1");
        entity.setNickName("test");

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update("test1234".getBytes());
        String password = new BigInteger(1, md.digest()).toString(16);
        entity.setPassword(password);
        entity.setGender(GenderEnum.FEMALE);
        entity.setBirthday(Instant.now());
        entity.setCreator("admin");

        int result = userMapper.create(entity);
        assertEquals(1, result);
    }
}