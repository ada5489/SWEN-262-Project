package Model;

public class DestinationTimeComparator {

  /**
   * returns a classic compare method for sorting the flight interfaces based on
   * airfare cost.
   * @param o1 the first flight interface
   * @param o2 the second flight interface
   * @return 1 if o1 leaves earlier, -1 if o2 is leaves earlier or 0 if they are equivalent
   */
  public int compare(FlightInterface o1, FlightInterface o2){
    Time to1 = new Time(o1.getDepartureTime());
    Time to2 = new Time((o2.getDepartureTime()));
    int time1 = to1.getTotalTime();
    int time2 = to2.getTotalTime();

    return Integer.compare(time1, time2);
  }

}
