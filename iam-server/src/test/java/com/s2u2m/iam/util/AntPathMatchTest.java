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

package com.s2u2m.iam.util;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AntPathMatchTest {

    @Test
    public void swaggerUrlAntMatch() {
        List<String> swaggerUrlPaths = Arrays.asList(
                "/swagger-ui.html"
        );
        var antMatcher = new AntPathMatcher();
        for (String swaggerUrlPath : swaggerUrlPaths) {
            boolean rst = antMatcher.match("/**/*swagger*/**", swaggerUrlPath);
            assertTrue(rst);
        }
    }
}