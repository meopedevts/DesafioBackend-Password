package br.com.meopedevts.passwordvalidate.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.meopedevts.passwordvalidate.exceptions.unmetCriteriaException;

@ControllerAdvice
public class PasswordValidateControllerAdvice {
    
    @ExceptionHandler(unmetCriteriaException.class)
    public ResponseEntity<Object> unmetCriteriaException (unmetCriteriaException e) {
        List<String> unmetCriteria = e.getUnmetCriteria();

        Map<String, Object> res = new LinkedHashMap<String, Object>();
        res.put("status", HttpStatus.BAD_REQUEST.value());
        res.put("message", "Password does not meet the criteria");
        res.put("unmet_Criteria", unmetCriteria);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
