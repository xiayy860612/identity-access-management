package com.s2u2m.iam.error;

import java.text.MessageFormat;

/**
 * @author Amos Xia
 */
public final class ModuleExceptionBuilder {

    public static void runtimeException(IModuleErrorDef error, Throwable cause,
                                        String msgPattern, Object... msgArgs) {
        String msg = MessageFormat.format(msgPattern, msgArgs);
        int errorCode = ModuleErrorBuilder.build(error);
        throw new IamRuntimeException(errorCode, msg, cause);
    }
}
