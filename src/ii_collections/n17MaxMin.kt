package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer?  = customers.maxBy { it.orders.size }
    // Return a customer whose order count is the highest among all customers

fun Customer.getMostExpensiveOrderedProduct(): Product? = orders.flatMap(Order::products).maxBy(Product::price)
    // Return the most expensive product which has been ordered
