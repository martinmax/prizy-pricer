package prizypricer

class ProductSurvey {

    String store;
    String note;
    BigDecimal price;

    static belongsTo = [product: Product]
    static constraints = {
        product nullable: false
        store blank: false
        note blank: true
        price min: 0 as BigDecimal, scale: 2
    }
}
