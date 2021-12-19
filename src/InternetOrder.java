
import java.util.HashMap;
import java.util.Objects;

public class InternetOrder implements Order {
    private Node root;
    private int n=0;
    public InternetOrder() {
        root=new Node();
        root.next=root;
        root.prev=root;
        root.food=null;
        root.price=0;
    }
    public InternetOrder(Item[] orders) {
        root=new Node();
        root.next=null;
        root.prev=root;
        root.food=orders[0];
        root.price=orders[0].getPrice();
        for (int i=1;i< orders.length;i++) {
            Node current=root;
            while (current.next!=null) {
                current=current.next;
            }
            current.next=new Node();
            current.next.food=orders[i];
            current.next.next=null;
            current.next.prev=current;
            current.next.price=orders[i].getPrice();
            n+=1;
        }
        Node current=root;
        while (current.next!=null) {
            current=current.next;
        }
        current.next=root;
        root.prev=current;
    }
    public boolean add(Item order) {
        if (root.food == null) {
            root.food=order;
            root.price=order.getPrice();
            n+=1;
            return true;
        }
        Node current=root.prev;
        current.next=new Node();
        current.next.food=order;
        current.next.price=order.getPrice();
        current.next.next=root;
        current.next.prev=root.prev;
        root.prev=current.next;
        n+=1;
        return true;
    }
    public boolean delOne(String name) {
        if (root.food!=null) {
            boolean q=false;
            Node current = root;
            int k1 = n;
            do {
                if (Objects.equals(current.food.getName(),name)) {
                    if (n == 1) {
                        current.food = null;
                        current.price = 0;
                        n--;
                    } else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                        n--;
                        if (current == root) root = root.next;

                    }
                    q=true;
                    break;
                }
                current = current.prev;
                k1--;
            }
            while (k1 != 0);
            return q;
        }
        return false;
    }
    public int del(String name) {
        if (root.food!=null) {
            Node current = root;
            int k = 0;
            int k1 = n;
            if (k1 != 0)
                do {
                    if (Objects.equals(current.food.getName(),name))
                        if (n == 1) {
                            current.food = null;
                            current.price = 0;
                            n--;
                            k += 1;
                        } else {
                            current.prev.next = current.next;
                            current.next.prev = current.prev;
                            k += 1;
                            n--;
                            if (current == root) root = root.next;
                        }
                    current = current.next;
                    k1--;
                }
                while (k1 != 0);
            return k;
        }
        return -1;
    }
    public int getN() {
        return n;
    }
    public String[] listWithoutRepeat() {
        if (root.food!=null) {
            Item[] orders = new Item[n];
            int k1 = n;
            int t = 0;
            Node current = root;
            while (k1 != 0) {
                orders[t] = current.food;
                current = current.next;
                k1--;
                t++;
            }
            String[] orders1 = new String[n];
            orders1[0] = orders[0].getName();
            int k2 = 1;
            for (int i = 1; i < n; i++)
                for (int j = 0; j < i; j++)
                    if (Objects.equals(orders[i].getName(),orders[j].getName()))
                        break;
                    else {
                        orders1[k2] = orders[i].getName();
                        k2++;
                    }
                   return orders1;
        }
        return null;
    }
    public Item[] list() {
        if (root.food != null) {
            Item[] orders = new Item[n];
            int k1 = n;
            int t = 0;
            Node current = root;
            while (k1 != 0) {
                orders[t] = current.food;
                current = current.next;
                k1--;
                t++;
            }
            return orders;
        }
        return null;
    }
    public int numberOfItem(String name) {
        int k=0;
        int k1=n;
        Node current=root;
        if (root.food!=null) {
            while (k1 != 0) {
                if (Objects.equals(current.food.getName(),name)) k++;
                k1--;
                current = current.next;
            }
            return k;
        }
        return -1;
    }
    public Item[] sortedList() {
        if (root.food != null) {
            Item[] orders = new Item[n];
            int k1 = n;
            int t1 = 0;
            Node current = root;
            while (k1 != 0) {
                orders[t1] = current.food;
                current = current.next;
                k1--;
                t1++;
            }
            for (int i = 1; i < orders.length; i++) {
                if (orders[i].getPrice() > orders[i - 1].getPrice()) {
                    Item t = orders[i];
                    while (t.getPrice() > orders[i - 1].getPrice()) {
                        orders[i] = orders[i - 1];
                        i = i - 1;
                        if (i == 0)
                            break;
                    }
                    orders[i] = t;
                }
            }
            return orders;
        }
        return null;
    }
    public int totalPrice() {
        int totalPrice=0;
        if (root.food != null) {
            Item[] orders = new Item[n];
            int k1 = n;
            int t = 0;
            Node current = root;
            while (k1 != 0) {
                orders[t] = current.food;
                current = current.next;
                k1--;
                t++;
            }
            for (int i=0;i< orders.length;i++)
                totalPrice=totalPrice+orders[i].getPrice();
            return totalPrice;
        }
        return -1;
}


}

