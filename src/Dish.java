public class Dish implements Item{
    private final int price;
    private final String name;
    private final String description;
    public Dish(int price,String name,String description) {
        if ((price < 0) && (name.equals("")) && (description.equals("")))
            throw new IllegalArgumentException();
        else {
            this.price = price;
            this.name = name;
            this.description = description;
        }
    }
    public Dish(String name,String description) {
        if ((name.equals("")) && (description.equals("")))
            throw new IllegalArgumentException();
        else {
            this.price = 0;
            this.name = name;
            this.description = description;
        }
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
