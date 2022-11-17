abstract class FoodDecorator implements Food {
    private Food newFood;

    public FoodDecorator(Food newFood) {
        this.newFood = newFood;
    }

    public String prepareFood() {
        return newFood.prepareFood();
    }

    public double FoodPrice() {
        return newFood.FoodPrice();
    }

}

class Cheese extends FoodDecorator {
    public Cheese(Food food) {
        super(food);
    }

    public String prepareFood() {
        return super.prepareFood() + ",Cheese";
    }

    public double FoodPrice() {
        return super.FoodPrice() + 5;
    }

}

class Drinks extends FoodDecorator {
    public Drinks(Food food) {
        super(food);
    }

    public String prepareFood() {
        return super.prepareFood() + ",Drinks";
    }

    public double FoodPrice() {
        return super.FoodPrice();
    }

}

class Coffee extends Drinks {
    public Coffee(Food food) {
        super(food);
    }

    public String prepareFood() {
        return super.prepareFood() + " Coffee";
    }

    public double FoodPrice() {
        return super.FoodPrice() + 6;
    }

}

class Water extends Drinks {
    public Water(Food food) {
        super(food);
    }

    public String prepareFood() {
        return super.prepareFood() + " Water";
    }

    public double FoodPrice() {
        return super.FoodPrice() + 3;
    }

}

class Coke extends Drinks {
    public Coke(Food food) {
        super(food);
    }

    public String prepareFood() {
        return super.prepareFood() + " Coke";
    }

    public double FoodPrice() {
        return super.FoodPrice() + 8;
    }

}

class Appetizer extends FoodDecorator {
    public Appetizer(Food food) {
        super(food);
    }

    public String prepareFood() {
        return super.prepareFood() + ",Appetizer";
    }

    public double FoodPrice() {
        return super.FoodPrice();
    }

}

class Onion_Ring extends Appetizer {
    public Onion_Ring(Food food) {
        super(food);
    }

    public String prepareFood() {
        return super.prepareFood() + " Onion Ring";
    }

    public double FoodPrice() {
        return super.FoodPrice() + 5;
    }

}

class French_Fry extends Appetizer {
    public French_Fry(Food food) {
        super(food);
    }

    public String prepareFood() {
        return super.prepareFood() + " French Fry";
    }

    public double FoodPrice() {
        return super.FoodPrice() + 5;
    }

}