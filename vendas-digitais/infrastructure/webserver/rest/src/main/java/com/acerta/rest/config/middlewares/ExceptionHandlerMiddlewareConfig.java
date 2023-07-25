package com.acerta.rest.config.middlewares;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.acerta.rest.config.middlewares.template.ExceptionModelTemplate;

@ControllerAdvice
public class ExceptionHandlerMiddlewareConfig extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {

    System.out.println("HttpMessageNotReadableException");

    return handleExceptionInternal(ex, "HttpMessageNotReadableException", new HttpHeaders(), status, request);
  }

  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {

    System.out.println("NoHandlerFoundException");
    String mensagem = "A rota '" + ex.getRequestURL() + "' não existe";
    return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {
    System.out.println("MethodArgumentNotValidException");

    BindingResult bindingResult = ex.getBindingResult();
    String message = null;

    if (bindingResult.getAllErrors().size() > 0) {
      message = bindingResult.getAllErrors().get(0).getDefaultMessage();
    }

    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    ExceptionModelTemplate problem = createTemplateException(httpStatus, "BADREQUEST", null, message);

    return handleExceptionInternal(ex, problem, headers, HttpStatus.BAD_REQUEST, request);
  }

  private ExceptionModelTemplate createTemplateException(HttpStatus status, String title, String message,
      String details) {
    ExceptionModelTemplate exceptionTemplate = new ExceptionModelTemplate();
    exceptionTemplate.setTimestamp(LocalDateTime.now());
    exceptionTemplate.setStatus(status.value());
    exceptionTemplate.setTitle(title);
    exceptionTemplate.setDetail(details);
    exceptionTemplate.setUserMessage(message);

    return exceptionTemplate;
  }
}
