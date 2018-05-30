package ii_collections

fun example2(list: List<Int>) {

    val isZero: (Int) -> Boolean = { it == 0 }

    val hasZero: Boolean = list.any(isZero)

    val allZeros: Boolean = list.all(isZero)

    val numberOfZeros: Int = list.count(isZero)

    val firstPositiveNumber: Int? = list.firstOrNull { it > 0 }
}

fun Customer.isFrom(city: City): Boolean = this.city == city

fun Shop.checkAllCustomersAreFrom(city: City): Boolean = customers.all { it.isFrom(city) }
    // Return true if all customers are from the given city


fun Shop.hasCustomerFrom(city: City): Boolean =customers.any{it.isFrom(city)}
    // Return true if there is at least one customer from the given city

fun Shop.countCustomersFrom(city: City): Int = customers.count{it.isFrom(city)}
    // Return the number of customers from the given city

fun Shop.findFirstCustomerFrom(city: City): Customer?  = customers.find { it.isFrom(city) }
    // Return the first customer who lives in the given city, or null if there is none
