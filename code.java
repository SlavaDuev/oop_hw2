import java.util.LinkedList;
import java.util.Queue;

interface QueueBehaviour {
    void enqueue(String person); 
    String dequeue(); 
    int queueSize(); 
}


interface MarketBehaviour {
    void acceptOrder(String order); 
    String deliverOrder(); 
}

class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<String> queue; 
    private Queue<String> orders; 

    public Market() {
        queue = new LinkedList<>();
        orders = new LinkedList<>();
    }

    public void enqueue(String person) {
        queue.add(person);
    }

    public String dequeue() {
        return queue.poll();
    }

    public int queueSize() {
        return queue.size();
    }

    public void acceptOrder(String order) {
        orders.add(order);
    }

    public String deliverOrder() {
        return orders.poll();
    }

    public void update() {
        if (!queue.isEmpty() && !orders.isEmpty()) {
            String person = dequeue();
            String order = deliverOrder();
            System.out.println("Человек " + person + " получил заказ " + order);
        } else {
            System.out.println("Очередь или заказы пусты");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        
        market.enqueue("Иван");
        market.enqueue("Мария");
        market.acceptOrder("Пицца");
        market.acceptOrder("Напиток");
        
        market.update();
        
        market.enqueue("Алексей");
        market.acceptOrder("Салат");
        
        market.update();
    }
}
