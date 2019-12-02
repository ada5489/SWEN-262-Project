package Model;

import java.util.Comparator;

public class TimeComparator implements Comparator<String> {

    /**
     *     Returns -1 if o1 < 02
     *     Returns 0 if equal
     *     Returns if o1 > o2
     */
    @Override
    public int compare(String o1, String o2) {
        Time to1 = new Time(o1);
        Time to2 = new Time(o2);
        int time1 = to1.getTotalTime();
        int time2 = to2.getTotalTime();

        return Integer.compare(time1, time2);
    }
}
