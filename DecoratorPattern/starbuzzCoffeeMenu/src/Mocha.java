//coding condiments
public class Mocha extends CondimentDecorator {
    public Mocha(Bevrage b){
        beverage = b;
    }

    public String getDescription(){
        return beverage.getDescription() + " with Mocha";
    }

    public double cost(){
        return beverage.cost() + 10;
    }
}
