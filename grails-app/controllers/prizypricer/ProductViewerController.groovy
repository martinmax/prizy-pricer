package prizypricer

import com.prizypricer.PrizyPricerException

class ProductViewerController {

    def productPriceService

    def show() {
        def product = Product.findByBarCode(params.barCode)
        if (!product) {
            return redirect(controller: 'productList', action: 'list')
        }
        def lowestPrice = productPriceService.getLowestPrice(product)
        def highestPrice = productPriceService.getHighestPrice(product)
        def averagePrice = productPriceService.getAveragePrice(product)
        def idealPrice
        def idealPriceError
        try {
            idealPrice = productPriceService.getIdealPrice(product)
        } catch (PrizyPricerException e) {
            idealPriceError = message(code: e.errorMessageCode)
        }
        def pricesCollected = productPriceService.getCollectedPricesForProduct(product)
        return [product   : product, lowestPrice: lowestPrice, highestPrice: highestPrice, averagePrice: averagePrice,
                idealPrice: idealPrice, idealPriceError: idealPriceError, pricesCollected: pricesCollected]
    }
}
