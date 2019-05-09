package com.s2u2m.iam.error;

import lombok.Getter;

/**
 * @author Amos Xia
 */
@Getter
public abstract class BaseIamException extends Exception {

    private final int errorCode;

    protected BaseIamException(final int code, String msg) {
        this(code, msg, null);
    }

    protected BaseIamException(final int code, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = code;
    }
}
