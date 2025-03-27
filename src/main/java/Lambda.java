public class Lambda {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, Lambda!");
            }
        };

        new Thread(() -> System.out.println("\"Hello, Lambda!\"")).start();
    }
}
