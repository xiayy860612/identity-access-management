package com.s2u2m.iam.error;

import com.s2u2m.iam.constant.ModuleEnum;
import lombok.Getter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ErrorBuilderTest {

    enum ModuleErrorTestEnum implements IModuleErrorDef {
        TEST_ERROR_1(1),
        ;

        @Getter
        private final byte code;

        ModuleErrorTestEnum(final int code) {
            this.code = (byte) code;
        }

        @Override
        public ModuleEnum getModule() {
            return ModuleEnum.ACCOUNT;
        }

    }

    @Test
    public void build() {
        int exp = 0x00000101;
        int error = ErrorBuilder.build(ModuleErrorTestEnum.TEST_ERROR_1);
        assertEquals(exp, error);
    }
}