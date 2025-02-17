// Subclass of Singleton
class SingletonChild extends Singleton {
    private static SingletonChild instance;

    // Protected constructor
    protected SingletonChild() {
        super();
    }

    // Overriding getInstance() to handle subclassing
    public static synchronized SingletonChild getInstance() {
        if (instance == null) {
            instance = new SingletonChild();
        }
        return instance;
    }

    @Override
    public void showMessage() {
        System.out.println("SingletonChild Instance: " + this);
    }
}
