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

import org.apache.ibatis.annotations.*;

/**
 * UsernameAccountMapper create on 19-2-23.
 *
 * @author Amos Xia
 */
@Mapper
public interface UsernameAccountMapper {

    @Insert("insert UsernameAccount\n" +
            "(username, userId, creator, updater)\n" +
            "select #{account.username}, #{account.userId}, now(), now()\n" +
            "from dual\n" +
            "where not exists (\n" +
            "    select 1\n" +
            "    from UsernameAccount\n" +
            "    where username=#{account.username} and valid=1\n" +
            ")\n" +
            "on duplicate update userId=#{account.userId}, valid=1")
    int create(@Param("account") UsernameAccountEntity account);

    @Select("select id, username, userId,\n" +
            "    valid, creator, createTime, updater, updateTime\n" +
            "from UsernameAccount\n" +
            "where username=#{username} and valid=1")
    UsernameAccountEntity select(@Param("username") String username);

    @Update("update UsernameAccount\n" +
            "set userId='', valid=0\n" +
            "where username=#{username}")
    int delete(String username);
}
