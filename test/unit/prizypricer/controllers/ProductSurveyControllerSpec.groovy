package prizypricer.controllers

import com.prizypricer.PrizyPricerException
import grails.test.mixin.TestFor
import prizypricer.EventsPushService
import prizypricer.ProductSurveyController
import prizypricer.ProductSurveyService
import spock.lang.Specification

@TestFor(ProductSurveyController)
class ProductSurveyControllerSpec extends Specification {

    def productSurveyService
    def eventsPushService

    def setup() {
        productSurveyService = Mock(ProductSurveyService)
        eventsPushService = Mock(EventsPushService)
        controller.productSurveyService = productSurveyService
        controller.eventsPushService = eventsPushService
    }

    def "test survey saved sucessfully, event is fired"() {

        when:
        controller.save()

        then:
        1 * productSurveyService.save(_, _) >> {}
        1 * eventsPushService.sendEvent(_, _, _) >> {}
        flash.message != null
        flash.error == null
        response.status == 200
    }

    def "test survey not created, exception was thrown and event is not fired"() {

        when:
        controller.save()

        then:
        1 * productSurveyService.save(_, _) >> { throw new PrizyPricerException() }
        0 * eventsPushService.sendEvent(_, _, _) >> {}
        flash.message == null
        flash.error != null
        response.status == 200
    }
}
