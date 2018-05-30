package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> =
        customers.filter { it.orders.flatMap(Order::products).contains(product) }
                .toSet()

    // Return the set of customers who ordered the specified product


fun Customer.getMostExpensiveDeliveredProduct(): Product? =
        orders.filter(Order::isDelivered)
                .flatMap(Order::products)
                .maxBy(Product::price)
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)


fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
        customers.flatMap(Customer::orders)
                .flatMap(Order::products)
                .count{ it == product }
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
