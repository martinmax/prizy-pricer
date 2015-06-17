package prizypricer

/**
 * Service used for {@link Product} searching
 * */
class ProductSearchService {

    /**
     * Intended to be used directly from the {@code Controller}, it searches for a matching {@link Product}
     * @params {@code def searchParams} is a data structure from the controller that stores the searchParams that are
     * required for the criteria builder, it stores max value,offset value, query string, etc
     *
     * @return {@code productList} list of all matching products
     * */
    def search(def searchParams) {
        def productList = Product.createCriteria().list(searchParams) {
            if (searchParams.query) {
                or {
                    ilike("barCode", "${searchParams.query}%")
                    ilike("description", "${searchParams.query}%")
                }
            }
        }
        return productList
    }

    def getProductsCount(def query, def productListSize) {
        return query ? productListSize : Product.count()
    }
}
