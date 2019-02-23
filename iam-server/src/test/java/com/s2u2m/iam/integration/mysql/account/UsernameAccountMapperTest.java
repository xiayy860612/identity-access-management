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

import com.s2u2m.iam.integration.mysql.BaseMySqlTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * UsernameAccountMapperTest create on 19-2-23.
 *
 * @author Amos Xia
 */
public class UsernameAccountMapperTest extends BaseMySqlTest {

    @Autowired
    private UsernameAccountMapper usernameAccountMapper;

    @Test
    public void create() {
        UsernameAccountEntity accountEntity = new UsernameAccountEntity();
        accountEntity.setUsername("test");
        accountEntity.setUserId("1");

        int result = usernameAccountMapper.create(accountEntity);
        assertEquals(1, result);
    }

    @Test
    public void select() {
        UsernameAccountEntity accountEntity = usernameAccountMapper.select("test_data");
        assertNotNull(accountEntity);
    }

    @Test
    public void delete() {
        int result = usernameAccountMapper.delete("test_data");
        assertEquals(1, result);

        UsernameAccountEntity accountEntity = usernameAccountMapper.select("test_data");
        assertNull(accountEntity);
    }

}