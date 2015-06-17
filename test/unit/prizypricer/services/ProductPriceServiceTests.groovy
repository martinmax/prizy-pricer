package prizypricer.services

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import prizypricer.Product
import prizypricer.ProductPriceService
import prizypricer.ProductSurvey

@TestFor(ProductPriceService)
@Mock([ProductSurvey, Product])
class ProductPriceServiceTests {

    private Product product
    private ProductSurvey productSurveyOne
    private ProductSurvey productSurveyTwo

    void setUp() {
        product = new Product(barCode: '123', description: 'Product on test').save(flush: true).save(flush: true)
        productSurveyOne = new ProductSurvey(product: product, store: 'Test Store', price: 100, note: 'Test Note').save(flush: true)
        productSurveyTwo = new ProductSurvey(product: product, store: 'Tineks', price: 200, note: 'Test Note').save(flush: true)
    }

    void tearDown() {
        Product.where {}.deleteAll()
        ProductSurvey.where {}.deleteAll()
    }

    void "test getHighest Product price"() {
        assert service.getHighestPrice(product) == 200
    }

    void "test getLowest Product price"() {
        assert service.getLowestPrice(product) == 100
    }

    void "test getAverage Product price"() {
        assert service.getAveragePrice(product) == 150
    }
}
