package com.prizypricer.calculation

/**
 * Interface definition describing an algorithm for calculating an ideal price
 * based on known past or surveyed prices for a product.
 */
interface IdealPriceCalculator {

    /**
     * @param prices of {@link Collection} of { @link Number}
     * @throws IdealPriceCalculatorException if the conditions for running the calculation
     * are not met, or otherwise an unrecoverable error occurs.
     *
     * @return ideal price as {@link Number}
     */
    Number calculate(Collection<? extends Number> prices) throws IdealPriceCalculatorException
}
