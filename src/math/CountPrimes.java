package math;

/**
 * Problem 204
 */
public class CountPrimes {
    public int countPrimes1(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i ++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i ++) {
            if (!isPrime[i]) continue;
            for(int j = i * i; j < n; j += i ) {
                isPrime[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i ++) {
            if (isPrime[i]) count ++;
        }
        return count;
    }

    public int countPrimes2(int n) {
        if ( n <= 2) return 0;

        int count = n / 2;
        boolean[] notPrime = new boolean[n];
        for (int i = 3; i * i < n; i += 2) {
            if (notPrime[i]) continue;

            for (int j = i * i; j < n; j += i * 2) {
                if (!notPrime[i]) {
                    count --;
                    notPrime[i] = true;
                }
            }
        }
        return count;
    }
}
