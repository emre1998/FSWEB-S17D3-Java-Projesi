package com.ZooAp.LombokInSpringBoot.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class AnimalException extends RuntimeException {
    private HttpStatus status;

    public AnimalException(String message,HttpStatus status) {
        super(message);
        this.status=status;
    }
}
