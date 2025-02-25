//coding condiments
public class Whip extends CondimentDecorator {
    public Whip(Bevrage b){
        beverage = b;
    }

    public String getDescription(){
        return beverage.getDescription() + " with Whip";
    }

    public double cost(){
        return beverage.cost() + 20;
    }
}
