grails.servlet.version = "3.0" // target container compliance (2.5 or 3.0)
grails.tomcat.nio = true
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolution = {
    inherits("global")
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()
    }
    dependencies {
        compile 'org.postgresql:postgresql:9.4-1201-jdbc41'
        compile 'org.spockframework:spock-grails-support:0.7-groovy-1.8'
        compile 'org.atmosphere:atmosphere-runtime:1.1.0.RC4'
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.2.14"
        compile(':events-push:1.0.M7') { excludes "resources", "atmosphere-runtime" }

        test ":spock:0.7"
        build ":tomcat:$grailsVersion"
    }
}
