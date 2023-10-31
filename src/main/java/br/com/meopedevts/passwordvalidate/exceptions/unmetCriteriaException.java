package br.com.meopedevts.passwordvalidate.exceptions;

import java.util.List;

public class unmetCriteriaException extends Exception {

    private List<String> unmetCriteria;
    
    public unmetCriteriaException(List<String> unmetCriteria) {
        this.unmetCriteria = unmetCriteria;
    }

    public List<String> getUnmetCriteria() {
        return unmetCriteria;
    }
}
