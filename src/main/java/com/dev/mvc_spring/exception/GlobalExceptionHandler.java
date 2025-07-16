package com.dev.mvc_spring.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception ex) {
        return new ResponseEntity<>("Unknown error : " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //    BindException	Dữ liệu không hợp lệ khi dùng @ModelAttribute
    //    MissingServletRequestParameterException	Thiếu @RequestParam
    //    HttpMessageNotReadableException	JSON không parse được (@RequestBody sai format)
    //    HttpRequestMethodNotSupportedException	Gọi sai method (POST thay vì GET,...)
    //    ResourceNotFoundException (custom)	Khi không tìm thấy dữ liệu
    //    IllegalArgumentException	Lỗi logic truyền sai tham số
    //    Exception	Lỗi tổng quát, fallback
}
