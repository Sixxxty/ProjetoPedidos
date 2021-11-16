package entities;

import enums.OrderStatus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();

    public Order(Date moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public String getMoment() {
        return DateFormat.getDateInstance().format(this.moment);
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return this.items;
    }
    public void addItem(OrderItem item) {
        items.add(item);
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double total() {
        double sum = 0.0;
        for(OrderItem item : items)
            sum += item.subTotal();
        return sum;
    }

}
