package br.com.meopedevts.passwordvalidate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.stereotype.Service;

import br.com.meopedevts.passwordvalidate.exceptions.unmetCriteriaException;
import br.com.meopedevts.passwordvalidate.model.PasswordDTO;

@Service
public class PasswordValidateService {

    private List<String> unmetCriteria = new ArrayList<>();

    private boolean minLengthValidate (String password) {
        if (password.length() >= 8) {
            return true;
        }

        return false;
    }

    private boolean hasUpperCaseValidate (String password) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);

        if (matcher.find()) {
            return true;
        } 

        return false;
    }

    private boolean hasLowerCaseValidate (String password) {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(password);

        if (matcher.find()) {
            return true;
        }

        return false;
    }

    private boolean hasNumericValidate (String password) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(password);

        if (matcher.find()) {
            return true;
        }

        return false;
    }

    private boolean hasEspecialCharacterValidate (String password) {
        Pattern pattern = Pattern.compile("[!@#$%&_]");
        Matcher matcher = pattern.matcher(password);

        if (matcher.find()) {
            return true;
        }

        return false;
    }

    private List<String> criteriaValidate (String password) {

        unmetCriteria.clear();

        if (!minLengthValidate(password)) {
            unmetCriteria.add("The password must contain at least 8 digits.");
        }

        if (!hasUpperCaseValidate(password)) {
            unmetCriteria.add("The password must contain at least one uppercase letter.");
        }

        if (!hasLowerCaseValidate(password)) {
            unmetCriteria.add("The password must contain at least one lowercase letter.");
        }

        if (!hasNumericValidate(password)) {
            unmetCriteria.add("The password must contain at least one number.");
        }

        if (!hasEspecialCharacterValidate(password)) {
            unmetCriteria.add("The password must contain at least one special character.");
        }

        return unmetCriteria;
    }
    
    public boolean validatePassword (PasswordDTO password) throws Exception {
        if (criteriaValidate(password.password()).isEmpty()) {
            return true;
        } else {
            throw new unmetCriteriaException(unmetCriteria);
        }
    }
}
