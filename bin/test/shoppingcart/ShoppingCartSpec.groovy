package shoppingcart

import spock.lang.Specification

class ShoppingCartSpec extends Specification {

    def cart

    def setup() {
        cart = new ShoppingCart()
    }

    def "Adds an item to the cart"() {
        given: "an empty cart"

        when: "an item is added"
        cart.addItem("apple", 1, 2.00)

        then: "the cart should contain the item with the correct quantity"
        cart.items.size() == 1
        cart.items[0].name == "apple"
    }

    def "Removes an item from the cart"() {
        given: "A cart with a few items"
        cart.addItem("apple", 2, 2.00)
        cart.length() != 0
        
        when: "you remove an item"
        cart.removeItem("apple")

        then: "the item should be removed from the cart"
        cart.length() == 0
    }

    def "Calculates the total price"() {
        given: "A cart with several items"
        cart.addItem("apple", 2, 2.00)
        cart.addItem("eggs", 1, 1.50)

        when: "you calculate the total price"
        def total = cart.total()

        then: "The total should be the sum of all the item prices multiplied by their quantities"
        total == (cart.items[0].price * cart.items[0].quantity) + (cart.items[1].price * cart.items[1].quantity)
    }
}