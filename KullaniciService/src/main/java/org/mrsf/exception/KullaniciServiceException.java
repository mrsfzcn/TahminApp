package org.mrsf.exception;

import lombok.Getter;

@Getter
public class KullaniciServiceException extends RuntimeException{

    private final ErrorType errorType;

    public KullaniciServiceException(ErrorType errorType, String  customMessage ) {
        super(customMessage);
        this.errorType = errorType;

    }

    public KullaniciServiceException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
