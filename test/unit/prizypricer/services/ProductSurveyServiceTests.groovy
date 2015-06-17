package prizypricer.services

import com.prizypricer.PrizyPricerException
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import prizypricer.Product
import prizypricer.ProductSurvey
import prizypricer.ProductSurveyService

@TestFor(ProductSurveyService)
@Mock([ProductSurvey, Product])
class ProductSurveyServiceTests {

    void tearDown() {
        Product.where {}.deleteAll()
    }

    void "test saving of ProductSurvey without a matching Product in the DB"() {
        def survey = new ProductSurvey(store: 'Tineks', price: 100, note: 'Test Note')

        shouldFail(PrizyPricerException) {
            service.save(survey, '123')
        }
    }

    void "test saving of ProductSurvey with a matching Product in the DB"() {
        def product = new Product(barCode: '123', description: 'something').save(flush: true)
        def survey = new ProductSurvey(product: product, productBarCode: '123', store: 'Tineks', price: 100, note: 'Test Note')

        assert service.save(survey, '123').equals(survey)
    }
}
