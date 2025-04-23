public interface DefaultStaticExampleInterface {
    default void show() {
        System.out.println("In Java 8- default method - DefaultStaticExampleInterface");
    }
    static void display() {
        System.out.println("In DefaultStaticExampleInterface I");
    }
}
