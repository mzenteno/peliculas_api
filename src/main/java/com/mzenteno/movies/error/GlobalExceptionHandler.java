package com.mzenteno.movies.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.mzenteno.movies.error.dto.ErrorMessageDTO;
import com.mzenteno.movies.error.exception.BadRequestException;
import com.mzenteno.movies.error.exception.ConflictException;
import com.mzenteno.movies.error.exception.InternalServerErrorException;
import com.mzenteno.movies.error.exception.ResourceNotFoundException;

import jakarta.validation.constraints.NotNull;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @SuppressWarnings("null")
  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    Throwable cause = ex.getCause();
      Map<String, String> errorResponse = new HashMap<>();

      if (cause instanceof InvalidFormatException) {
          InvalidFormatException e = (InvalidFormatException) cause;
          String fieldName = e.getPath().get(0).getFieldName();
          errorResponse.put(fieldName, String.format("El valor '%s' no es válido para el campo '%s'. Debe ser un número entero.", e.getValue(), fieldName));
      } else {
          errorResponse.put("error", "Error de formato en el cuerpo de la solicitud");
      }

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }

  @SuppressWarnings("null")
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, @NotNull WebRequest request) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error ->
        errors.put(error.getField(), error.getDefaultMessage())
    );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorMessageDTO> handleResourceNotFoundException(ResourceNotFoundException e){
    ErrorMessageDTO response = new ErrorMessageDTO(HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ErrorMessageDTO> handleBadRequestException(BadRequestException e){
    ErrorMessageDTO response = new ErrorMessageDTO(HttpStatus.BAD_REQUEST.value(), "Bad Request", e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(ConflictException.class)
  public ResponseEntity<ErrorMessageDTO> handleConflictException(ConflictException e){
    ErrorMessageDTO response = new ErrorMessageDTO(HttpStatus.CONFLICT.value(), "Conflict", e.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
  }

  @ExceptionHandler(InternalServerErrorException.class)
  public ResponseEntity<ErrorMessageDTO> handleInternalServerErrorException(InternalServerErrorException e) {
    ErrorMessageDTO response = new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", e.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }

}