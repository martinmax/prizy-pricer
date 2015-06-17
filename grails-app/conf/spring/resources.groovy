import com.prizypricer.PrizyPricerIdealPriceCalculator
import grails.util.Environment

beans = {
    // Default implementation of the IdealPriceCalculator, each environment
    // can specify its own implementation, see example below.
    idealPriceCalculator(PrizyPricerIdealPriceCalculator)

    Environment.executeForCurrentEnvironment {

    // Here you can set your custom environment and inject an implementation of the IdealPriceCalculator
        //  Example :
        //  someOtherPrizyPricerInstance {
        //      idealPriceCalculator(SomeOtherImplementationOfIdealPriceCalculator)
        //  }
    }
}