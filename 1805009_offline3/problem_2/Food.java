interface Food
{
    public String prepareFood();
    public double FoodPrice();
    
}
class Burger implements Food
{
    public String prepareFood()
    {
      return "Burger";
    }
    public double FoodPrice()
    {
        return 0;
    }
    
}
class Veggi extends Burger
{
    public String prepareFood()
    {
        return "Veggi "+super.prepareFood();
    }
    public double FoodPrice()
    {
        return super.FoodPrice()+10;
    }
}
class Beef extends Burger
{  public String prepareFood()
    {
        return "Beef "+super.prepareFood();
    }
    public double FoodPrice()
    {
        return super.FoodPrice()+30;
    }

}
class Chicken extends Burger
{  public String prepareFood()
    {
        return "Chicken "+super.prepareFood();
    }
    public double FoodPrice()
    {
        return super.FoodPrice()+20;
    }

}