package org.mrsf.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR_SERVER(5100,"Sunucu Hatası",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4100,"Parametre Hatası",HttpStatus.BAD_REQUEST),
    USERNAME_EXIST(4110,"Bu kullanıcı adı zaten var", HttpStatus.BAD_REQUEST),
    USER_NOT_CREATED(4111, "Kullanıcı oluşturulamadı", HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4112,"Kullanici adi veya sifre hatali",HttpStatus.NOT_FOUND),
    ACCOUNT_NOT_ACTIVE(4113,"Hesap aktif değil",HttpStatus.FORBIDDEN),
    USER_NOT_FOUND(4114,"Boyle bir kullanici bulunamadi",HttpStatus.NOT_FOUND),
    ;
    private  int code;
    private String message;
    HttpStatus httpStatus;
}
