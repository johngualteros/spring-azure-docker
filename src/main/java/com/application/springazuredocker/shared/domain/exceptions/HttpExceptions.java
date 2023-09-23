package com.application.springazuredocker.shared.domain.exceptions;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

import java.net.URI;

public class HttpExceptions {
    public static ResponseEntity<?> createProblemResponse(HttpStatus status, String url, String error, String title, Integer code) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(status, error);
        pd.setTitle(title);
        pd.setType(URI.create(url));
        pd.setProperty("Error", error);
        return ResponseEntity.status(code).body(pd);
    }
}
