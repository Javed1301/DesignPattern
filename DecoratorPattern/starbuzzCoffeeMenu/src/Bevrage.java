public abstract class Bevrage {
    String description = "Unknnown description";
    public enum Size{Tall,Grande,Venti};
    Size size = Size.Tall;

    public String getDescription(){
        return description;
    }

    public void setSize(Size size){
        this.size = size;
    }

    public Size getSize(){
        return size;
    }

    public abstract double cost();
}
