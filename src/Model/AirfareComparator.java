package Model;

import java.util.Comparator;

public class AirfareComparator implements Comparator<FlightInterface> {

  /**
   * returns a classic compare method for sorting the flight interfaces based on
   * airfare cost.
   * @param o1 the first flight interface
   * @param o2 the second flight interface
   * @return 1 for o1 is greater priced -1 if o2 is greater or 0 if they are equivalent
   */
  @Override
  public int compare(FlightInterface o1, FlightInterface o2) {
    if(o1.getAirfare() > o2.getAirfare())
      return 1;
    else if (o2.getAirfare() > o1.getAirfare())
      return -1;
    else
      return 0;
  }
}
