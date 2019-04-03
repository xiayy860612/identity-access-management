package com.s2u2m.iam.error;

/**
 * @author Amos Xia
 */
public final class ErrorBuilder {

    public static int build(IModuleErrorDef error) {
        byte moduleCode = error.getModule().getCode();
        byte moduleErrorCode = error.getCode();
        return moduleCode << Byte.SIZE | moduleErrorCode;
    }

}
