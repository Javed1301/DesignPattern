public class Singleton {

    private static Singleton instance;

    // Protected constructor to allow subclassing
    protected Singleton() {
        
    }

    // Public method to provide access to instance
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton Instance: " + this);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("--------------------Program Started-----------------");
         // Base Singleton
         Singleton singleton1 = Singleton.getInstance();
         singleton1.showMessage();
 
         // Subclass Singleton
         SingletonChild singletonChild1 = SingletonChild.getInstance();
         singletonChild1.showMessage();
 
         // Checking if instances are same
         Singleton singleton2 = Singleton.getInstance();
         SingletonChild singletonChild2 = SingletonChild.getInstance();
 
         System.out.println("Base Singleton instances same? " + (singleton1 == singleton2));
         System.out.println("Child Singleton instances same? " + (singletonChild1 == singletonChild2));

    }
}
