package com.s2u2m.iam.error;

import com.s2u2m.iam.constant.ModuleEnum;

/**
 * @author Amos Xia
 */
public interface IModuleErrorDef {
    /**
     * Define errors belong to specific module
     *
     * @return Module of Errors
     */
    ModuleEnum getModule();

    /**
     * return error code defined in module error
     *
     * @return error code in byte
     */
    byte getCode();
}
