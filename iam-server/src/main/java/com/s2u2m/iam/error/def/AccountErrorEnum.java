package com.s2u2m.iam.error.def;

import com.s2u2m.iam.constant.ModuleEnum;
import com.s2u2m.iam.error.IModuleErrorDef;
import lombok.Getter;

/**
 * @author Amos Xia
 */
public enum AccountErrorEnum implements IModuleErrorDef {
    /**
     *
     */
    ACCOUNT_EXISTED(1),
    ;

    @Getter
    private final byte code;
    AccountErrorEnum(final int code) {
        this.code = (byte) code;
    }

    @Override
    public ModuleEnum getModule() {
        return ModuleEnum.ACCOUNT;
    }

}
