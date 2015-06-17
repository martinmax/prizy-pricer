package prizypricer

import com.prizypricer.PrizyPricerException

class ProductSurveyController {

    static allowedMethods = [save: "POST"]
    static defaultAction = "create"
    def productSurveyService
    def eventsPushService

    def create() {
        [productSurvey: new ProductSurvey(params)]
    }

    def save() {
        def productSurvey = new ProductSurvey(params);
        try {
            productSurveyService.save(productSurvey, params.barCode)
            flash.message = message(code: 'survey.create.success')
            flash.error = null
            eventsPushService.sendEvent('browser', 'newSurveyCreated', params.barCode)
            render(view: "create")
        } catch (PrizyPricerException e) {
            flash.error = message(code: e.errorMessageCode, args: [params.barCode])
            flash.message = null
            render(view: "create", model: [productSurvey: productSurvey])
        }
    }
}
