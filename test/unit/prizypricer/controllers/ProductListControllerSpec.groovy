package prizypricer.controllers

import grails.test.mixin.TestFor
import prizypricer.Product
import prizypricer.ProductListController
import prizypricer.ProductSearchService
import spock.lang.Specification

@TestFor(ProductListController)
class ProductListControllerSpec extends Specification {

    def productSearchService

    def setup() {
        productSearchService = Mock(ProductSearchService)
        controller.productSearchService = productSearchService

    }

    def "test when products are found"() {
        when:
        controller.list()

        then:
        1 * productSearchService.search(controller.params) >> [new Product(barCode: '1', description: 'test')]
        response.status == 200
        flash.error == null
    }

    def "test when no products are found"() {
        when:
        controller.list()

        then:
        1 * productSearchService.getProductsCount(_,_) >> { return 0 }
        response.status == 200
        flash.error != null
    }
}
