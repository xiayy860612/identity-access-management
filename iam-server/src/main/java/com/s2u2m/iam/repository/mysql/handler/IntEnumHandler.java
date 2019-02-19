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

package com.s2u2m.iam.repository.mysql.handler;

import com.s2u2m.iam.constant.IIntEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * IntEnumHandler create on 19-2-19.
 *
 * @author Amos Xia
 */
public final class IntEnumHandler<ET extends IIntEnum> implements TypeHandler<ET> {

    private final Map<Integer, ET> intEnumMapper;

    public IntEnumHandler(Class<ET> et) {
        this.intEnumMapper = Stream.of(et.getEnumConstants())
                .collect(Collectors.toMap(IIntEnum::getValue, Function.identity()));
    }
    @Override
    public void setParameter(
            PreparedStatement preparedStatement,
            int i, ET et, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, et.getValue());
    }

    @Override
    public ET getResult(ResultSet resultSet, String s) throws SQLException {
         return this.intEnumMapper.getOrDefault(resultSet.getInt(s), null);
    }

    @Override
    public ET getResult(ResultSet resultSet, int i) throws SQLException {
        return this.intEnumMapper.getOrDefault(resultSet.getInt(i), null);
    }

    @Override
    public ET getResult(CallableStatement callableStatement, int i) throws SQLException {
        return this.intEnumMapper.getOrDefault(callableStatement.getInt(i), null);
    }
}
