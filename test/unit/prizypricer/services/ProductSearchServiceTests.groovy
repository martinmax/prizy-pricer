package prizypricer.services

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import prizypricer.Product
import prizypricer.ProductSearchService

@TestFor(ProductSearchService)
@Mock(Product)
class ProductSearchServiceTests {

    private Product productOne
    private Product productTwo
    def params

    void setUp() {
        productOne = new Product(barCode: '1', description: 'ProductOne').save(flush: true)
        productTwo = new Product(barCode: '2', description: 'ProductTwo').save(flush: true)
        params = [:]
        params.max = 5
    }

    void tearDown() {
        Product.where {}.deleteAll()
    }

    void "test search without query, expecting all products to be returned"() {
        params.query = ""
        def productList = service.search(params)

        assert productList.size() == 2
        assert productList.contains(productOne)
        assert productList.contains(productTwo)
        assert service.getProductsCount(params.query, productList.size()) == 2
    }

    void "test search with query, searching by barCode, expecting one result"() {
        params.query = "1"
        def productList = service.search(params)

        assert productList.size() == 1
        assert productList.contains(productOne)
        assert service.getProductsCount(params.query, productList.size()) == 1
    }

    void "test search with query, searching by description, expecting one result"() {
        params.query = "ProductOne"
        def productList = service.search(params)

        assert productList.size() == 1
        assert productList.contains(productOne)
        assert service.getProductsCount(params.query, productList.size()) == 1
    }
}
