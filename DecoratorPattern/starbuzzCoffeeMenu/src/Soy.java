//coding condiments
public class Soy extends CondimentDecorator {
    public Soy(Bevrage b){
        beverage = b;
    }

    public String getDescription(){
        return beverage.getDescription() + " with Soy";
    }

    public double cost(){
        return beverage.cost() + 30;
    }
}
