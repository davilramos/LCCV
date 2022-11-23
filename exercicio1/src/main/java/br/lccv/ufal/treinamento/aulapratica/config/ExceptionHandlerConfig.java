package br.lccv.ufal.treinamento.aulapratica.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerConfig {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // mudar o response status 200
    @ExceptionHandler(RuntimeException.class)
    public String runTimeHandler(RuntimeException ex) {
        return "Erro de runtime!=>" + ex.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handlerValidation(MethodArgumentNotValidException ex) {
        List<String> erros = new LinkedList<>();
        ex.getFieldErrors().forEach(error -> erros.add(error.getDefaultMessage()));
        return erros;
    }
}
