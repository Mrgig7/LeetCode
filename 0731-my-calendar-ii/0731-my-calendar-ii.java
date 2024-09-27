import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    List<int[]> sb;
    List<int[]> db;

    public MyCalendarTwo() {
        sb = new ArrayList<>();
        db = new ArrayList<>();
    }

    public boolean book(int st, int en) {
        for (int[] bk : db) {
            if (st < bk[1] && en > bk[0]) {
                return false; 
            }
        }
        for (int[] bk : sb) {
            if (st < bk[1] && en > bk[0]) {
                db.add(new int[] { Math.max(st, bk[0]), Math.min(en, bk[1]) });
            }
        }

        sb.add(new int[] { st, en });
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(st,end);
 */

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(st,end);
 */