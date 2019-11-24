package Database;

import Database.AirportDatabase;
import Database.FlightDatabase;


public class DataBaseManager {

  private AirportDatabase adb;
  private FlightDatabase fdb;


  public DataBaseManager(AirportDatabase abd,FlightDatabase fdb ){
    this.adb = abd;
    this.fdb = fdb;
  }



  public AirportDatabase getAdb()
  {
    return adb;
  }
  public FlightDatabase getFdb()
  {
    return fdb;
  }

}
