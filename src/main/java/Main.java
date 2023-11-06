public class Main {
    public static void main(String[] args) {
        // Hang doi
        QueueADT<Order> orderQueueADT =  new QueueADTImpl<>(100);

        // Tao order 1 va order 2, sau do -> dua vao hang doi
        Product product1 = new Product(1, "San pham 1", 1000);
        Product product2 = new Product(2, "San pham 2", 3000);

        // Tao hoa don
        Order order1 = new Order(1);
        order1.setCustomerName("ABC");
        order1.setCustomerPhone("122334444");
        order1.setOrderDate("2023-10-10");
        // Co hoa don chi tiet
        order1.getOrderItems().add(new OrderItem(1, product1, 2));
        order1.getOrderItems().add(new OrderItem(2, product2, 3));
        // Tinh tong tien
        long t = 0;
        for (OrderItem order: order1.getOrderItems()) {
            t = t + order.getItem().getPrice() * order.getQuanity();
        }
        order1.setTotalAmount(t);






        // Tao hoa don
        Order order2 = new Order(2);
        order2.setCustomerName("DEF");
        order2.setCustomerPhone("2222222");
        order2.setOrderDate("2023-10-11");
        // Co hoa don chi tiet
        order2.getOrderItems().add(new OrderItem(1, product1, 2));
        // Tinh tong tien
        long t1 = 0;
        for (OrderItem order: order1.getOrderItems()) {
            t1 = t1 + order.getItem().getPrice() * order.getQuanity();
        }
        order2.setTotalAmount(t1);

        // Them vao hang doi
        orderQueueADT.enqueue(order2);
        orderQueueADT.enqueue(order1);

        // Duyet cac hoa don co trong hang doi -> duyet don va in ra
        while (true){
            Order order = orderQueueADT.dequeue();
            if(order == null) break;
            order.setStatus(true);
            order.printOrder();
        }
        System.out.println("Ket thuc xu ly hoa don");

    }
}
