public class TestPrimeFactorization {
    public static void main(String[] args) {
        LazyPrimeFactorization lazyPrime = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimizedPrime = new OptimizedPrimeFactorization();

        Thread lazyThread = new Thread(lazyPrime);
        Thread optimizedThread = new Thread(optimizedPrime);

        lazyThread.start();
        optimizedThread.start();
    }
}
