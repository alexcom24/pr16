public final class Drink implements Item{
    private final int price;
    private final String name;
    private final String description;
    public Drink(int price,String name,String description) {
        this.price=price;
        this.name=name;
        this.description=description;
    }
    public Drink(String name,String description) {
        this.price=0;
        this.name=name;
        this.description=description;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
