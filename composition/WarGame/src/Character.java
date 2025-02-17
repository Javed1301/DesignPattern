public abstract class Character {
    WeaponBehavior weapon;

    public Character(){}

    public abstract void fight();

    public void getWeapon(){
        weapon.useWeapon();
    }

    public void setWeapon(WeaponBehavior w){
        weapon = w;
    }
}
