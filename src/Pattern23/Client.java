package Pattern23;

public class Client {
    public static void main(String[] args) {
        SingletonTest04 s1 = SingletonTest04.getInstance();
        SingletonTest04 s2 = SingletonTest04.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(SingletonTest05.INSTANCE == SingletonTest05.INSTANCE);
    }
}
