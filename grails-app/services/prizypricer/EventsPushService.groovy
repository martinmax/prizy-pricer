package prizypricer

/**
 * {@code EventsPushService} act as a wrapper class service for sending events to the Grails Event-Push plugin
 * */
class EventsPushService {

    /**
     * @param {@code String namespace} namespace of the event
     * @param {@code String topic} topic of where this event will be sent
     * @param {@code def data} data that will be sent together with the event to the subscriber
     *
     * It sends event based on the @params it receives
     *
     * @return event
     * */
    def sendEvent(String namespace, String topic, def data) {
        return event([namespace: namespace, topic: topic, data: data])
    }
}
