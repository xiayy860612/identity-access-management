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

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * UserMapper create on 19-2-17.
 *
 * @author Amos Xia
 */
@Mapper
public interface UserMapper {

    @Insert("insert into User " +
            "(id, nickName, password, gender, birthday, " +
            "creator, updater) " +
            "values " +
            "(#{entity.id}, #{entity.nickName}, #{entity.password}, #{entity.gender}, #{entity.birthday}, " +
            "#{entity.creator}, #{entity.creator})")
    int create(@Param("entity") UserEntity entity);

    @Select("select id, nickName, password, gender, birthday,\n" +
            "    valid, creator, createTime, updater, updateTime\n" +
            "from User\n" +
            "where id=#{id}")
    UserEntity select(@Param("id") String id);
}
