public interface Order {
    public boolean add(Item order);
    public boolean delOne(String name);
    public int del(String name);
    public int getN();
    public Item[] list();
    public int totalPrice();
    public int numberOfItem(String name);
    public String[] listWithoutRepeat();
    public Item[] sortedList();

}
