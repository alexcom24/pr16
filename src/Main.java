public class Main {
    public static void main(String[] args) throws OrderAlreadyAddedException, IllegalTableNumberException {
        Dish dish=new Dish(23,"Meat","Cold");
        Drink drink=new Drink(18,"Beer","German");
        RestaurantOrder rest=new RestaurantOrder();
        rest.add(dish);
        rest.add(drink);
        Dish dish1=new Dish(62,"Fish","Frozen");
        Drink drink1=new Drink(10,"Tea","Green");
        InternetOrder inter=new InternetOrder();
        inter.add(dish1);
        inter.add(drink1);
        OrderManager manager=new OrderManager();
        manager.addOrder(rest,4);
        manager.addOrder(inter,"Vernadskogo Street");

    }
}
