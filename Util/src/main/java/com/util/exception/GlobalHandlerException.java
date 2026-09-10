package com.util.exception;

import com.util.common.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    private ResponseDto setResponse(String message){
        ResponseDto response = new ResponseDto();
        response.setStatus("FAILED");
        response.setMessage(message);
        return response;
    }

    @ExceptionHandler(UserInactiveException.class)
    public ResponseEntity<ResponseDto> handleUserInactiveException(UserInactiveException e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(setResponse(e.getMessage()));
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ResponseDto> handleDuplicateResourceException(DuplicateResourceException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(setResponse(e.getMessage()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDto> handleResourceNotFoundException(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(setResponse(e.getMessage()));
    }

    @ExceptionHandler(ThirdPartyApiException.class)
    public ResponseEntity<ResponseDto> handleThirdPartyApiException(ThirdPartyApiException ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(setResponse(ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(setResponse(e.getMessage()));
    }
}
