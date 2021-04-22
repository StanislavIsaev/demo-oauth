package com.example.demooauth;

import lombok.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/secure")
public class SecureController {

    @PreAuthorize("hasRole('ROLE_ANON')")
    @GetMapping(path = "/get", produces = APPLICATION_JSON_VALUE)
    public ApiResponse<?> get() {
        return ApiResponse.of(Instant.now());
    }

    @Value(staticConstructor = "of")
    public static class ApiResponse<T> {
        T data;
    }
}
