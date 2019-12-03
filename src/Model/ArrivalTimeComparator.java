package Model;

import java.util.Comparator;

public class ArrivalTimeComparator implements Comparator<FlightInterface> {

  /**
   * returns a classic compare method for sorting the flight interfaces based on
   * airfare cost.
   * @param o1 the first flight interface
   * @param o2 the second flight interface
   * @return 1 if o1 arrives earlier, -1 if o2 is arrives earlier or 0 if they are equivalent
   */
  public int compare(FlightInterface o1, FlightInterface o2){
    Time to1 = new Time(o1.getArrivalTime());
    Time to2 = new Time((o2.getArrivalTime()));
    int time1 = to1.getTotalTime();
    int time2 = to2.getTotalTime();

    if (time1 > time2){return 1;}
    else if( time2 > time1) {return -1;}
    else return 0;
  }


}
