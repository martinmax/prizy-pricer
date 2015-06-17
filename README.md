# PrizyPricer
### Purpose
The company ‘Prizy’ wants to start conducting surveys of prices for different products, and calculate an ‘Ideal Price’ for a product based on the collected information.

The idea is to have a number of workers walk into a store, and with their iPads access a web application where they enter prices as they see them. In real time, an administrator will be able to see the entered prices using the same web application and the application will provide an ‘Ideal Price’ for a specific product.

### Features
PrizyPricer is a grails application for the company Prizy. It enables: 

  - Submiting Product Surveys
  - Listing and searching Products
  - Viewing the selected products and get updates for the prices in realtime

### Version
1.0.0

## Technical details

### Installation and Configuration

PrizyPricer uses [grails 2.0.3] and [postgres] database server. Once you've downloaded Grails please follow this [grails-wiki] for instalation and [postgres-wiki] for postgres instalation.

While installing Postgres you will be asked for user and password, so you will need to update the DataSource.groovy file accordingly. Default ones that are currently used are: 
- User: 'postgres'
- Password: 'admin'

Once you've set up postgres you'll need to create a new database named 'prizyPricer'

```sh
CREATE DATABASE prizyPricer;
```

>Note: If you're not using the postgresdb on your localhost address, please change it in the DataSoruces.groovy,. This also applies for the default Port which is 5432

### Testing
Tests for the application are placed in test\unit\prizypricer and separated based on their domain. This means tests for the IdealPriceCalculator are placed in /calculator, tests for the Services are placed in /services and tests for the Controllers are placed in /controller.

Tests can be run with the command:
```sh
grails test-app
```
This command will run all Spock, Grails and JUinit tests in the Grails embeded H2 database.

### Development
##### Ideal price calculator

PrizyPricer allows different implementations of the **IdealPriceCalculator** to be set up for each environment. The current/default one is the PrizyPricerIdealPriceCalculator, but can be changed for each environment, each environment can provide it's own implementation.

**Example:** 
```
    Environment.executeForCurrentEnvironment {
          someOtherPrizyPricerInstance {
              idealPriceCalculator(SomeOtherImplementationOfIdealPriceCalculator)
          }
    }
```
##### Database
If the application is run in the development environment, there are predefined products in BootStrap.groovy that will be inserted in the database on startup.

##### Running 
The default environment is development. To start it up, just run the following command:
```sh
grails run-app
```

### Code
The source code can be found on [GitHub]
<!---
Links
-->
[grails 2.0.3]:https://grails.org/
[postgres]:www.postgresql.org/download/
[postgres-wiki]:https://wiki.postgresql.org/wiki/Detailed_installation_guides
[grails-wiki]:https://grails.org/wiki/Installation
[GitHub]:https://github.com/martinmax/prizy-pricer
