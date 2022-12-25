import java.io.*;
import java.lang.*;
import java.util.*;

import static java.lang.Math.*;


public class _Template {

    private static void solve() throws IOException {
        //Solve here

    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
        out.close();
    }

    static final FastReader sc = new FastReader();
    static final PrintWriter out = new PrintWriter(System.out);
    static StringBuilder ans = new StringBuilder();
    static boolean[] prime;
    static final Random random = new Random();
    static int M = 1_000_000_007;

    static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        Arrays.sort(arr);
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long nCk(int n, int k) {
        return (modMult(fact(n), power(modMult(fact(n - k), fact(k)), M - 2)));
    }

    static long fact(long n) {

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = modMult(fact, i);
        }
        return fact % M;
    }

    static int lowerbound(int[] ar, int el){
        int l = 0, r = ar.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(ar[mid]==el) return mid;
            else if (ar[mid]>el) r = mid-1;
            else l = mid+1;
        }
        return l;
    }

    static long modMult(long a, long b) {
        return a * b % M;
    }

    static long power(long x, long y) {
        long res = 1;
        x = x % M;
        if (x == 0)
            return 0;
        while (y > 0) {
            if ((y & 1) != 0)
                res = (res * x) % M;
            y = y >> 1;
            x = (x * x) % M;
        }
        return res;
    }

    static void sieveOfEratosthenes(int n) {
        prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
        prime[0] = false;
        if (1 <= n)
            prime[1] = false;
        for (int p = 2; p * p <= n; p++) {

            if (prime[p]) {

                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }

    static int[] arrayIn(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static class Pair<E, F> implements Comparable {
        private E v1;
        private F v2;

        Pair(E v1, F v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        Pair() {
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    static class SegmentTree {
        int[] seg;//Seg array should be of size 4n

        SegmentTree(int n){
            seg=new int[4*n];
        }

        void build(int index, int l, int r, int[] ar) {
            if (l == r) {
                seg[index] = ar[l];
                return;
            }
            int mid = l + (r - l) / 2;
            build(2 * index + 1, l, mid, ar);
            build(2 * index + 2, mid, r, ar);
            seg[index] = Math.min(seg[2 * index + 1], seg[2 * index + 2]);
        }

        int query(int index, int l, int r, int ql, int qr) {
            // No Overlap: (ql qr l r) || (l r ql qr)
            if (qr < l || r < ql) return (int) 1e9;
            // Complete Overlap: (ql l r qr)
            if (l <= ql && qr <= r) return seg[index];

            int mid = l + (r - l) / 2;
            int left = query(2*index+1,l,mid,ql,qr);
            int right = query(2*index+2,mid,r,ql,qr);
            return Math.min(left,right);
        }

        void update(int index, int l,int r,int updateIndex, int val){
            if(l==r){
                seg[index]= val;
                return;
            }

            int mid=l+(r-l)/2;
            if(updateIndex<=mid) update(2*index+1,l,mid,updateIndex,val);
            else update(2*index+2,mid,r,updateIndex,val);
            seg[index]=Math.min(seg[2*index+1],seg[2*index+2]);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
