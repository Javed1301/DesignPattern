public class CompositePatternExample {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Rectangle rectangle1 = new Rectangle();

        Group group1 = new Group();
        group1.add(circle1);
        group1.add(rectangle1);

        Circle circle2 = new Circle();
        Group group2 = new Group();
        group2.add(circle2);
        group2.add(group1); // Adding group1 inside group2

        System.out.println("Drawing entire structure:");
        group2.draw(); // This should recursively draw all elements
    }
}