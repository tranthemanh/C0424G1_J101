public class TestThread {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        // Start odd thread
        oddThread.start();

        try {
            // Wait for odd thread to finish
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start even thread
        evenThread.start();
    }
}
