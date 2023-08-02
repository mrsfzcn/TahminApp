package org.mrsf.exception;

import lombok.Getter;

@Getter
public class TahminServiceException extends RuntimeException{

    private final ErrorType errorType;

    public TahminServiceException(ErrorType errorType, String  customMessage ) {
        super(customMessage);
        this.errorType = errorType;

    }

    public TahminServiceException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
