package com.gabriel.securityvault.infrastructure.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auditavel {
    String acao(); // Isso define que a anotação precisa de um valor "acao"
}