package com.prizypricer

import com.prizypricer.calculation.IdealPriceCalculator
import com.prizypricer.calculation.IdealPriceCalculatorException

/**
 * {@link IdealPriceCalculator} implementation that applies the following calculation
 * for calulating the ideal price: add {@code 20%} to the the average of all prices
 * after removing the 2 lowest and 2 highest prices from the list. 
 * The calculation will complete successfully if, and only if, there is at least one
 * price left in the list after removing the lowest/highest. Otherwise it throws {@link IdealPriceCalculatorException}
 */
class PrizyPricerIdealPriceCalculator implements IdealPriceCalculator {

    @Override
    BigDecimal calculate(Collection<? extends Number> prices) {
        if (!isEligableForIdealPriceCalculation(prices)) {
            throw new IdealPriceCalculatorException('calculation.idealPriceCalculator.error')
        }
        prices.sort()
        prices = removeFirstTwoPricesFromList(prices)
        prices = removeLastTwoPricesFromList(prices)
        return getAveragePrice(prices) * 1.20
    }

    private boolean isEligableForIdealPriceCalculation(List<BigDecimal> prices) {
        return prices != null && prices.size() > 4
    }

    private List<BigDecimal> removeLastTwoPricesFromList(List<BigDecimal> prices) {
        return prices.take(prices.size() - 2)
    }

    private List<BigDecimal> removeFirstTwoPricesFromList(List<BigDecimal> prices) {
        return prices.drop(2)
    }

    private BigDecimal getAveragePrice(List<BigDecimal> prices) {
        return prices.sum() / prices.size()
    }
}
