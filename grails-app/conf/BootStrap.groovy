import grails.util.Environment
import prizypricer.Product

class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.DEVELOPMENT) {
            def productOne = new Product(barCode: '1',description: 'Protein').save(failOnError: true)
            def productTwo = new Product(barCode: '2',description: 'Amino').save(failOnError: true)
            def productThree = new Product(barCode: '3',description: 'Creatin').save(failOnError: true)
            def productFour = new Product(barCode: '4',description: 'Fat burner').save(failOnError: true)
            def productFive = new Product(barCode: '5',description: 'T-shirt').save(failOnError: true)
            def productSix = new Product(barCode: '6',description: 'Vitamin').save(failOnError: true)
            def productSeven = new Product(barCode: '7',description: 'Omega').save(failOnError: true)
            def productEight = new Product(barCode: '8',description: 'Beta Alannin').save(failOnError: true)
            def productNine = new Product(barCode: '9',description: 'Glutamin').save(failOnError: true)
            def productTen = new Product(barCode: '10',description: 'L-arginin').save(failOnError: true)
        }
    }
    def destroy = {
    }
}
