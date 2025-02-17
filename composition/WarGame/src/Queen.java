public class Queen extends Character {
    
    public Queen(){
        weapon = new BowAndArrow();
    }
    
    @Override
    public void fight(){
        System.out.println("Queen " );
        this.getWeapon();
    }
}
