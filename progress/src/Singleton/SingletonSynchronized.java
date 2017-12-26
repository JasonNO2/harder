package Singleton;

public class SingletonSynchronized {
    /*
        双重锁单例模式
    */

    private static SingletonSynchronized synchronizedSingleton;

    private SingletonSynchronized() {
    }

    public static SingletonSynchronized newInstance(){
        if (synchronizedSingleton == null) {
            synchronized (SingletonSynchronized.class) {
                if (synchronizedSingleton == null) {
                    synchronizedSingleton = new SingletonSynchronized();
                }
            }
        }
        return synchronizedSingleton;
    }
}
