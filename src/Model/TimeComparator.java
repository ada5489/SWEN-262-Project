package Model;


public class TimeComparator {

    /**
     *     Returns -1 if o1 < 02
     *     Returns 0 if equal
     *     Returns if o1 > o2
     */
    public int compare(String o1, String o2, Integer sum) {
        Time to1 = new Time(o1);
        Time to2 = new Time(o2);
        int time1 = to1.getTotalTime() + sum;
        int time2 = to2.getTotalTime();

        return Integer.compare(time1, time2);
    }
}
