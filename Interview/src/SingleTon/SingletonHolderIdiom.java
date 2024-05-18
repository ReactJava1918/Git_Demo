package SingleTon;
public class SingletonHolderIdiom {
    private SingletonHolderIdiom() {}

    private static class SingletonHolder {
        private static final SingletonHolderIdiom instance = new SingletonHolderIdiom();
    }

    public static SingletonHolderIdiom getInstance() {
        return SingletonHolder.instance;
    }
}
