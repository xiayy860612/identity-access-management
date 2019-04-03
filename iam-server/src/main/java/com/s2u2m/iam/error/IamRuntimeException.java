package com.s2u2m.iam.error;

import lombok.Getter;

/**
 * @author Amos Xia
 */
@Getter
public final class IamRuntimeException extends RuntimeException {

    private final int errorCode;

    protected IamRuntimeException(final int code, String msg) {
        this(code, msg, null);
    }

    protected IamRuntimeException(final int code, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = code;
    }
}
