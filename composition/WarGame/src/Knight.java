public class Knight extends Character {
    
    public Knight(){
        weapon = new SwordBehavior();
    }
    
    @Override
    public void fight(){
        System.out.println("Knight " );
        this.getWeapon();
    }
}
