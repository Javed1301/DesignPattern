public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();
        mallard.performFly();

        System.out.println("\nTesting a ModelDuck:");
        Duck model = new ModelDuck();
        model.display();
        model.performFly(); // Initially can't fly
        model.setFlyBehavior(new FlyWithWings()); // Change behavior at runtime
        System.out.println("Changing ModelDuck's flying behavior...");
        model.performFly(); // Now it can fly!
    }
}
