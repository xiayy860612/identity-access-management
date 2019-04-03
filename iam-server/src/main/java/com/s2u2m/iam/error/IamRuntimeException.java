package com.s2u2m.iam.error;

import lombok.Getter;

/**
 * @author Amos Xia
 */
@Getter
public final class IamRuntimeException extends RuntimeException {

    private final int errorCode;

    IamRuntimeException(final int code, String msg) {
        this(code, msg, null);
    }

    IamRuntimeException(final int code, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = code;
    }

    IamRuntimeException(BaseIamException exception) {
        this(exception.getErrorCode(), exception.getMessage(), exception.getCause());
    }
}
