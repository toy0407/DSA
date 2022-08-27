package Greedy;

import java.io.IOException;
import java.util.*;


public class Meetings1 {

    static class MeetingTimes{
        int s,f,count;

        public MeetingTimes(int s, int f, int count) {
            this.s = s;
            this.f = f;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] s=new int[n];
        int[] f=new int[n];
        int i;
        for (i=0;i<n;i++){
            s[i]=sc.nextInt();
        }
        for (i=0;i<n;i++){
            f[i]=sc.nextInt();
        }
        int max=maxMeetingInRoom(s,f,n);
        System.out.println(max);
    }

    private static int maxMeetingInRoom(int[] s, int[] f,int n) {
        int i;
        ArrayList<MeetingTimes> ar=new ArrayList<>();
        for (i=0;i<n;i++){
                ar.add(new MeetingTimes(s[i],f[i],i+1));
        }
        Collections.sort(ar, new Comparator<MeetingTimes>() {
            @Override
            public int compare(MeetingTimes o1, MeetingTimes o2) {
                return o1.f-o2.f;
            }
        });

        ArrayList<MeetingTimes> ans=new ArrayList<>();
        ans.add(ar.get(0));
        for (i=1;i<n;i++){
            if (ar.get(i).s>ans.get(ans.size()-1).f){
                ans.add(ar.get(i));
            }
        }
        for (i=0;i<ans.size();i++){
            System.out.print(ans.get(i).count+" ");
        }
        System.out.println();
        return ans.size();
    }
}
