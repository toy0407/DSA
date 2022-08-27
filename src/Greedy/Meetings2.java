package Greedy;

import java.util.Arrays;
import java.util.List;

public class Meetings2 {
    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int st = 0, e = 0, c = 0, max = 0;
        while (st < intervals.size()) {
            if (start[st] < end[e]) {
                c++;
                st++;
            } else {
                c--;
                e++;
            }
            max = Math.max(max, c);
        }
        return max;
    }
}
