package com.s2u2m.iam.constant;

import lombok.Getter;

/**
 * @author Amos Xia
 */
public enum ModuleEnum {
    /**
     * Account module
     */
    ACCOUNT(1),
    ;

    @Getter
    private final byte code;
    ModuleEnum(final int code) {
        this.code = (byte) code;
    }
}
