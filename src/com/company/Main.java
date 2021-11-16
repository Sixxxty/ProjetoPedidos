package com.company;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Scanner sc = new Scanner(System.in);
        System.out.println("Digite os dados do usuario");

        System.out.print("Nome: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date: ");
        Date birthDate = sdf.parse(sc.nextLine());

        Client c1 = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        Order order = new Order(new Date(), status);

        for(int i = 1; i <= n ; i++) {
            System.out.println("Enter #" + i + " item data: ");
            sc.nextLine();
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product Price: ");
            Double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            order.addItem(new OrderItem(quantity, productPrice, productName));
        }
        String date = order.getMoment().toString();
        System.out.println("ORDER SUMMARY:");
        System.out.print("Order momment: " + date + "\n");
        System.out.print("Order status: " + order.getStatus() + "\n");
        System.out.println("Client: " + c1);
        System.out.println("Order items: ");

        for(OrderItem item : order.getItems()) {
            System.out.println(item);
        }
        System.out.print("Total value: $" + order.total());
    }
}
