package com.prizypricer

/**
 * Use instead of {#ling RuntimeException} for any type of exception. Extend it with more specific exceptions as needed.
 */
class PrizyPricerException extends RuntimeException {

    /**
     * i18n code for the user-readable message describing the error.
     */
    String errorMessageCode

    PrizyPricerException(String errorMessageCode) {
        super("No user-readable message available, please see "
                + "PrizyPricerException.errorMessageCode for more info about the i18n code: " + errorMessageCode)
        this.errorMessageCode = errorMessageCode
    }
}
