package br.com.meopedevts.passwordvalidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.meopedevts.passwordvalidate.model.PasswordDTO;
import br.com.meopedevts.passwordvalidate.service.PasswordValidateService;

@RestController
@RequestMapping("/validate-password")
public class PasswordValidateController {

    @Autowired
    private PasswordValidateService service;
    
    @PostMapping()
    public ResponseEntity<Void> validatePassword(@RequestBody PasswordDTO password) throws Exception {
        boolean isValid = service.validatePassword(password);

        if (isValid) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
}
