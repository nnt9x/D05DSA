public class Main2 {
    public static void main(String[] args) {
        QueueADT<Integer> queueADT = new QueueADTImpl<>(100);
        queueADT.enqueue(10);
        queueADT.enqueue(20);
        System.out.println(queueADT);
    }
}
