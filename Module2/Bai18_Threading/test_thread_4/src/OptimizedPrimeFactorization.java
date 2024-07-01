public class OptimizedPrimeFactorization implements Runnable {
    @Override
    public void run() {
        long number = 2;
        while (true) {
            if (isPrime(number)) {
                System.out.println("OptimizedPrimeFactorization found prime: " + number);
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number < 2) return false;
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
