package prizypricer

class ProductListController {

    static defaultAction = "list"
    def productSearchService

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 5, 100)
        def productList = productSearchService.search(params)
        def productListSize = productList == null ? 0 : productList.size()
        params.productsCount = productSearchService.getProductsCount(params.query, productListSize)
        flash.error = params.productsCount == 0 ? message(code: 'products.not.found') : null
        return [products: productList, productsCount: params.productsCount]
    }
}
