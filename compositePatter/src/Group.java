import java.util.ArrayList;
import java.util.List;

class Group implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    public void add(Graphic graphic) {
        children.add(graphic);
    }

    public void remove(Graphic graphic) {
        children.remove(graphic);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Group:");
        for (Graphic graphic : children) {
            graphic.draw(); // Calls draw() recursively on child objects
        }
    }
}
