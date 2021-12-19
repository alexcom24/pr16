import java.util.Objects;
import java.util.HashMap;
public class OrderManager {
    private Order[] orders=new Order[100];
    private int k=0; // счётчик ресторанных заказов
    private int k1=0; // счётчик интернет-заказов
    private HashMap<String,Order> ord=new HashMap<>();
    public void addOrder(RestaurantOrder order, int numTable) throws OrderAlreadyAddedException {
        try {
            if (numTable>99) throw new IllegalTableNumberException("Нет столика с таким номером");
            try {
                if (orders[numTable]==null) {
                    k += 1;
                    orders[numTable] = order;
                }
                else throw new OrderAlreadyAddedException("Со столиком уже связан заказ");
            }
            catch(OrderAlreadyAddedException e) {
                System.err.println(e.getMessage());
            }
        }
        catch(IllegalTableNumberException e) {
            System.err.println(e.getMessage());
        }
    }
    public void addOrder(InternetOrder order,String address) {
        ord.put(address,order);
        k1++;
    }
    public void getOrder(int numTable) {
        try {
            if (numTable>99) throw new IllegalTableNumberException("Нет столика с таким номером");
            System.out.println(orders[numTable]);
        }
        catch(IllegalTableNumberException e) {
            System.err.println(e.getMessage());
        }
    }
    public void getOrder(String address) {
        System.out.println(ord.get(address));
    }
    public void deleteOrder(String address) {
        if (ord.get(address)!=null) {
            ord.remove(address);
            k1--;
        }
    }
    public void deleteOrder(int numTable) {
        try {
            if (numTable>99) throw new IllegalTableNumberException("Нет столика с таким номером");
            if (orders[numTable] != null) {
                orders[numTable] = null;
                k--;
            }
        }
        catch(IllegalTableNumberException e) {
            System.err.println(e.getMessage());
        }
    }
    public Order[] internet() {
        if (k1!=0) {
            Order[] q = new Order[100];
            int u = 0;
            for (Order key : ord.values()) {
                q[u] = key;
                u++;
            }
            return q;
        }
        return null;

    }
    public void addItemtoOrder(int numTable, Item item) {
        try {
            if (numTable>99) throw new IllegalTableNumberException("Нет столика с таким номером");
            if (orders[numTable] != null)
                orders[numTable].add(item);
        }
        catch(IllegalTableNumberException e) {
            System.err.println(e.getMessage());
        }
    }
    public void addItemtoOrder(String address,Item item) {
        if (ord.get(address)!=null)
        ord.get(address).add(item);
    }
    public int InternetSum() {
        int tPrice=0;
        if (k1!=0) {
            for (Order key : ord.values())
                tPrice+=key.totalPrice();
            return tPrice;
        }
        return -1;
    }
    public int quantity(String name) {
        int quantity=0;
        if (k1!=0) {
            for (Order key : ord.values())
                quantity+=key.numberOfItem(name);
            return quantity;
        }
        return -1;
    }


}
