package leetcode.editor.yiwei;

import java.util.Arrays;

/**
 * 如何高效寻找素数
 * 如果一个数只能被1和它自身整除,那么这个数就是素数,1不是素数
 */
public class Primes {
    public static void countPrime(int n){
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        for (int i = 2; i < n ; i++) {
            if (isPrime[i]){
                // i的倍数不可能是素数了
                for (int j = 2*i; j < n ; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static int countPrimes2(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int counts = countPrimes2(10);
        System.out.println(counts);
    }
}
