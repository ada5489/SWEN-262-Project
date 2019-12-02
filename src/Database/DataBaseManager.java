package Database;

import Database.AirportDatabase;
import Database.FlightDatabase;


public class DataBaseManager {

  private AirportDatabase adb;
  private FlightDatabase fdb;
  private ReservationDatabase rdb;


  public DataBaseManager(AirportDatabase abd,FlightDatabase fdb, ReservationDatabase rdb ){
    this.adb = abd;
    this.fdb = fdb;
    this.rdb = rdb;
  }



  public AirportDatabase getAdb()
  {
    return adb;
  }
  public FlightDatabase getFdb()
  {
    return fdb;
  }

  public ReservationDatabase getRdb() {
    return rdb;
  }
}
