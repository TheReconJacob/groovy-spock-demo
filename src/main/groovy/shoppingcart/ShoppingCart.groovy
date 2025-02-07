package shoppingcart

class ShoppingCart {
    List<Item> items = []

    void addItem(String name, int quantity, double price) {
        items.add(new Item(name, quantity, price))
    }

    void removeItem(String name) {
        items.removeIf { it.name == name }
    }

    double total() {
        items.sum { it.price * it.quantity }
    }

    int length() {
        items.size()
    }
}