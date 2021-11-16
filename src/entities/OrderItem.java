package entities;

public class OrderItem {
    private String name;
    private Integer quantity;
    private Double price;

    public OrderItem(Integer quantity, Double price, String name) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double subTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return this.name +", $" +this.price+", Quantity: "+this.quantity+", Subtotal: $" + this.subTotal();
    }
}
