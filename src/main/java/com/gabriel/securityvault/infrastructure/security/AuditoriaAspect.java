package com.gabriel.securityvault.infrastructure.security;

import com.gabriel.securityvault.infrastructure.database.entity.AuditoriaEntity;
import com.gabriel.securityvault.infrastructure.database.repository.AuditoriaRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Aspect
@Component
public class AuditoriaAspect {

    private final AuditoriaRepository repository;

    public AuditoriaAspect(AuditoriaRepository repository) {
        this.repository = repository;
    }

    @Around("@annotation(auditavel)")
    public Object auditar(ProceedingJoinPoint joinPoint, Auditavel auditavel) throws Throwable {
        Object resultado = joinPoint.proceed(); // Executa o UseCase original

        String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
        
        AuditoriaEntity log = new AuditoriaEntity();
        log.setUsuario(usuario);
        log.setAcao(auditavel.acao());
        log.setStatus("SUCESSO");
        log.setDataHora(LocalDateTime.now());
        
        repository.save(log);
        
        return resultado;
    }
}