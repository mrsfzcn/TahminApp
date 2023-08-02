package org.mrsf.exception;

import lombok.Getter;

@Getter
public class SehirServiceException extends RuntimeException{

    private final ErrorType errorType;

    public SehirServiceException(ErrorType errorType, String  customMessage ) {
        super(customMessage);
        this.errorType = errorType;

    }

    public SehirServiceException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
