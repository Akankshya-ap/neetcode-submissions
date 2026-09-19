/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size()<=1) return true;
        intervals.sort((a,b)->(a.start == b.start?a.end-b.end:a.start-b.start));

        Interval curr = intervals.get(0);
        for(int i = 1; i<intervals.size(); i++){
            Interval now = intervals.get(i);
            if(now.start<curr.end) {
                return false;
            }else{
                curr=now;
            }
        }
        return true;

    }
}
