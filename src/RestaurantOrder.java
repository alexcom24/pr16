import java.util.Objects;

public class RestaurantOrder implements Order {
    private int n=0;
    private Item[] orders=new Item[50];
    public boolean add(Item order) {
        orders[n]=order;
        n++;
        return true;
    }
    public boolean delOne(String name) {
        if (n!=0) {
            boolean q = false;
            for (int i = 0; i < n; i++) {
                if (Objects.equals(orders[i].getName(), name)) {
                    //    orders[i]=null;
                    for (int j = i; j < n; j++)
                        orders[j] = orders[j + 1];
                    n--;
                    q = true;
                    break;
                }
            }
            return q;
        }
        return false;
    }
    public int del(String name) {
        if (n!=0) {
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (Objects.equals(orders[i].getName(), name)) {
                    //    orders[i]=null;
                    for (int j = i; j < n; j++)
                        orders[j] = orders[j + 1];
                    n--;
                    k++;
                }
            }
            return k;
        }
        return -1;
    }
    public int getN() {
        return n;
    }
    public Item[] list() {
        if (n!=0)
        return orders;
        else return null;
    }
    public int totalPrice() {
        if (n!=0) {
            int totPrice = 0;
            for (int i = 0; i < n; i++) {
                totPrice = totPrice + orders[i].getPrice();
            }
            return totPrice;
        }
        return -1;
    }
    public int numberOfItem(String name) {
        if (n!=0) {
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (Objects.equals(orders[i].getName(), name)) {
                    k++;
                }
            }
            return k;
        }
        return -1;
    }
    public String[] listWithoutRepeat() {
        if (n!=0) {
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
    public Item[] sortedList() {
        if (n!=0) {
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
}
