package com.strohwitwer.awesomevalidation.validators;

import com.strohwitwer.awesomevalidation.ValidationHolder;
import com.strohwitwer.awesomevalidation.utility.ValidationCallback;

import java.util.regex.Matcher;

public class BasicValidator extends Validator {

    @Override
    public boolean trigger() {
        return checkFields(new ValidationCallback() {
            @Override
            public void execute(ValidationHolder validationHolder, Matcher matcher) {
                validationHolder.getEditText().setError(validationHolder.getErrMsg());
            }
        });
    }

    @Override
    public void halt() {
        for (ValidationHolder validationHolder : mValidationHolderList) {
            validationHolder.getEditText().setError(null);
        }
    }

}