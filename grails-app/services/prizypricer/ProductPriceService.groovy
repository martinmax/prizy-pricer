package prizypricer

import com.prizypricer.PrizyPricerException
import com.prizypricer.calculation.IdealPriceCalculatorException

/**
 * Service used for calculation of prices for a specific product
 * */
class ProductPriceService {

    def idealPriceCalculator

    BigDecimal getLowestPrice(Product product) {
        def productPrices = getAllPricesForProduct(product)
        return productPrices.size() > 0 ? productPrices.min() : 0
    }

    BigDecimal getHighestPrice(Product product) {
        def productPrices = getAllPricesForProduct(product)
        return productPrices.size() > 0 ? productPrices.max() : 0
    }

    BigDecimal getAveragePrice(Product product) {
        def productPrices = getAllPricesForProduct(product)
        return productPrices.size() > 0 ? (productPrices.sum() / productPrices.size()) : 0
    }

    /**
     * @throws {@link PrizyPricerException} if an error, exception {@link IdealPriceCalculatorException} is thrown
     * occurs calculating the ideal price for the {@code product}.
     */
    BigDecimal getIdealPrice(Product product) {
        try {
            return idealPriceCalculator.calculate(getAllPricesForProduct(product))
        }
        catch (IdealPriceCalculatorException e) {
            throw new PrizyPricerException(e.errorMessageCode)
        }
    }

    def getCollectedPricesForProduct(Product product) {
        return ProductSurvey.countByProduct(product)
    }

    private List<BigDecimal> getAllPricesForProduct(Product product) {
        def productSurveys = ProductSurvey.findAllByProduct(product)
        return productSurveys.size() > 0 ? productSurveys.collect { p -> p.getPrice() } : []
    }
}
