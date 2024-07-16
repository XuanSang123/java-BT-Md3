package BaiTapXXI;

public class Bai6 {
    public static void main(String[] args) {
        LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization();
        Thread thread1 = new Thread(lazyPrimeFactorization);
        Thread thread2 = new Thread(optimizedPrimeFactorization);
        thread1.start();
        thread2.start();
    }
}

class LazyPrimeFactorization implements Runnable {
    @Override
    public void run() {
        int n = 2;
        while (true) {
            if (isPrime(n)) {
                System.out.println("LazyPrimeFactorization: " + n);
            }
            n++;
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class OptimizedPrimeFactorization implements Runnable {
    @Override
    public void run() {
        int n = 2;
        while (true) {
            if (isPrime(n)) {
                System.out.println("OptimizedPrimeFactorization: " + n);
            }
            n++;
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}