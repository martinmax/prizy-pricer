package com.prizypricer.calculation

/**
 * Generic {@link RuntimeException} for the {@link IdealPriceCalculator}
 * */
class IdealPriceCalculatorException extends RuntimeException {

    /**
     * i18n code for the user-readable message describing the error.
     */
    String errorMessageCode

    IdealPriceCalculatorException(String errorMessageCode) {
        super("No user-readable message available, please see "
                + "IdealPriceCalculatorException.errorMessageCode for more info about the i18n code: " + errorMessageCode)
        this.errorMessageCode = errorMessageCode
    }
}
