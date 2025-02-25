//IMplementing the abstract Beverage class for the Condiments (the decorators)
public abstract class CondimentDecorator extends Bevrage {
    Bevrage beverage;
    public abstract String getDescription();
}
