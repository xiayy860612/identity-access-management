package com.s2u2m.iam.error;

import java.text.MessageFormat;

/**
 * @author Amos Xia
 */
public final class ExceptionBuilder {

    public static void runtimeException(IModuleErrorDef error, Throwable cause,
                                        String msgPattern, Object... msgArgs) {
        String msg = MessageFormat.format(msgPattern, msgArgs);
        int errorCode = ErrorBuilder.build(error);
        throw new IamRuntimeException(errorCode, msg, cause);
    }

    public static void runtimeException(IModuleErrorDef error, String msgPattern, Object... msgArgs) {
        runtimeException(error, null, msgPattern, msgArgs);
    }

    public static void runtimeException(BaseIamException exception) {
        throw new IamRuntimeException(exception);
    }
}
