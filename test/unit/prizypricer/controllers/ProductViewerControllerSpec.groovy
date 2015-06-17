package prizypricer.controllers

import com.prizypricer.PrizyPricerException
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import prizypricer.Product
import prizypricer.ProductPriceService
import prizypricer.ProductViewerController
import spock.lang.Specification

@TestFor(ProductViewerController)
@Mock(Product)
class ProductViewerControllerSpec extends Specification {

    def productPriceService

    def setup() {
        productPriceService = Mock(ProductPriceService)
        controller.productPriceService = productPriceService
    }

    def "test product not found, redirects to list"() {
        when:
        controller.show()

        then:
        response.redirectedUrl == '/productList/list'
    }

    def "test product is found but cannot show ideal price"() {
        setup:
        new Product(barCode: '1', description: 'testProduct').save(flush: true)
        controller.params.barCode = '1'

        when:
        def show = controller.show()

        then:
        1 * productPriceService.getIdealPrice(_) >> { throw new PrizyPricerException() }
        1 * productPriceService.getHighestPrice(_)
        1 * productPriceService.getLowestPrice(_)
        1 * productPriceService.getCollectedPricesForProduct(_)
        show.idealPriceError != null
        response.status == 200
    }

    def "test product is found and show ideal price"() {
        setup:
        new Product(barCode: '1', description: 'testProduct').save(flush: true)
        controller.params.barCode = '1'

        when:
        def show = controller.show()

        then:
        1 * productPriceService.getIdealPrice(_)
        1 * productPriceService.getHighestPrice(_)
        1 * productPriceService.getLowestPrice(_)
        1 * productPriceService.getCollectedPricesForProduct(_)
        show.idealPriceError == null
        response.status == 200

        cleanup:
        Product.where {}.deleteAll()
    }
}
