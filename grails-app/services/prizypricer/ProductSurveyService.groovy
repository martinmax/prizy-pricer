package prizypricer

import com.prizypricer.PrizyPricerException

/**
 * Service for {@link ProductSurvey}
 * */
class ProductSurveyService {

    /**
     * @param {@code ProductSurvey productSurvey} survey you want to be saved
     * @param {@code String productBarCode} product bar code for the survey
     * @throws {@link PrizyPricerException} if the provided product bar code doesn't match with a product in the database
     *
     * @return instance of the saved {@code productSurvey}
     * */
    ProductSurvey save(ProductSurvey productSurvey, String productBarCode) {
        def product = Product.findByBarCode(productBarCode);
        if (product == null) {
            throw new PrizyPricerException('survey.create.error');
        }
        productSurvey.setProduct(product)
        return productSurvey.save()
    }
}
