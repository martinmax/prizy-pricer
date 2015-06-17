package prizypricer.calculation

import com.prizypricer.PrizyPricerIdealPriceCalculator
import com.prizypricer.calculation.IdealPriceCalculatorException
import junit.framework.TestCase
import org.junit.Test

class PrizyPricerIdealPriceCalculatorTests extends TestCase {

    def prizyPricerIdealPriceCalculator

    @Override
    protected void setUp() throws Exception {
        prizyPricerIdealPriceCalculator = new PrizyPricerIdealPriceCalculator()
    }

    @Test(expected = IdealPriceCalculatorException)
    void "test calculation with less than four prices"() {
        def prices = [1]
        prizyPricerIdealPriceCalculator.calculate(prices)
    }
    
    @Test
    void "test calculation that will correctly calculate the price for the ordered input prices"() {
        def prices = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        assert prizyPricerIdealPriceCalculator.calculate(prices) == 6.6
    }

    @Test
    void "test calculation that will correctly calculate the price for the unordered input prices"() {
        def prices = [10, 4, 9, 2, 5, 6, 7, 8, 3, 1]
        assert prizyPricerIdealPriceCalculator.calculate(prices) == 6.6
    }

    @Test
    void "test calculation that will correctly calculate the price with 5 prices"() {
        def prices = [10, 4, 7, 8, 3]
        assert prizyPricerIdealPriceCalculator.calculate(prices) == 8.4
    }
}
