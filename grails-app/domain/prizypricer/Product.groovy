package prizypricer

class Product {

    String barCode
    String description

    static constraints = {
        barCode blank: false, unique: true
        description blank: false
    }
    static mapping = {
        id generator: 'assigned', name: 'barCode'
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false
        return barCode == ((Product) o).barCode
    }

    int hashCode() {
        return barCode.hashCode()
    }
}
