public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;

        // Factory method call
        pizza = createPizza(type);

        // Standard process for preparing a pizza
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // Factory method (to be implemented by subclasses)
    protected abstract Pizza createPizza(String type);
}

