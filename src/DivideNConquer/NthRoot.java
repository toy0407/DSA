package DivideNConquer;

import java.io.IOException;
import java.util.Scanner;

public class NthRoot {
    static double e=0.01;
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        double req=sc.nextInt();
        double n=sc.nextInt();
        double s=0;
        if (n==1){
            System.out.println(req);return;
        }
        else if (n==0) s=-1;
        else if (req>=0 && req<1) s = getnthRoot(0, 1, n, req);
        else s = getnthRoot(0, req, n, req);
        System.out.println(s);
    }

    static double getnthRoot(double l, double r, double n,double req){
        double mid=(l+r)/2;
        if (Math.abs(Math.pow(mid,n)-req)<e) return mid;
        if (Math.pow(mid,n)==req) return mid;
        if (Math.pow(mid,n)>req) return getnthRoot(l, mid, n, req);
        if (Math.pow(mid,n)<req) return getnthRoot(mid, r, n, req);
        return -1;
    }
}
