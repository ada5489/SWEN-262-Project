package Model;

/**
 * Time is a helper used to define things for connection times and other comparators used
 * Puts the time in a given integer minutes to be compared to.
 * takes in a String time then converts it into int
 */
public class Time {
  private String stringRep;
  private int totalTime;


  public Time(String timeRepresentation){
  stringRep = timeRepresentation;
  totalTime = convertTimeToMins(timeRepresentation);
  }

  /**
   * @precondition to represent 12:00a should be given in 00:00a format
   * converts a given string time in the format
   * HH:MMAP to a total time from 12 am to be compared
   *
   * example 3:30p
   * Step 1: split the string into two pieces, one hour piece and one minute piece with am or pm at end
   * step 2: get the integer representation of those strings
   * step 3: add 12 hours if the time is pm or am
   * step 4: get the time in minutes from 00:00a or 12:00 am
   * @param stringRep the string representation format used in the data files of the CSV
   * @return the time in minutes from 12 am
   */
  public int convertTimeToMins(String stringRep){
    int time;
    String[] timePieces = stringRep.split(":");
    boolean isPm = timePieces[1].charAt(2) == 'p';

    String minutesTime = timePieces[1].substring(0,2);
    String hourTime = timePieces[0];

    int minutes = Integer.parseInt(minutesTime);
    int hours = Integer.parseInt(hourTime);

    if (isPm && hours != 12){
      hours += 12;
    }
    time = hours * 60 + minutes;
    return  time;
  }

  public int getTotalTime(){
    return totalTime;
  }
  public String getStringRep(){
    return stringRep;
  }

  public String toString(){
    String str = getStringRep() + " in minutes is: " + getTotalTime();
    return str;
  }


  public static void main(String [] args){

    String timeTest = "3:32p";
    String[] times = {"3:31a", "5:52p", "7:01a", "12:01p", "12:00a", "9:00a", "00:01a"};
    for (String time :
        times) {

    Time tim = new Time((time));
    System.out.println(tim);
    }

  }
}
