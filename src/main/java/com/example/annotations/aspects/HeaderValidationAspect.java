package com.example.annotations.aspects;
import com.example.annotations.custom.AllowByHeader;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
public class HeaderValidationAspect {

    private final HttpServletRequest request;

    public HeaderValidationAspect(HttpServletRequest request) {
        this.request = request;
    }

    @Around("@annotation(allowByHeader)")
    public Object validateHeader(ProceedingJoinPoint joinPoint, AllowByHeader allowByHeader) throws Throwable {
        String field = allowByHeader.field();
        String expectedValue = allowByHeader.value();

        String actualValue = request.getHeader(field);

        if (!StringUtils.hasText(actualValue) || !expectedValue.equals(actualValue)) {
            throw new SecurityException("Access denied. Invalid request header field or value.");
        }
        System.out.println("Validation is successful");
        return joinPoint.proceed();
    }
}

