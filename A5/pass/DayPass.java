package pass;
//@author William Kennedy
//License

import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class DayPass implements Pass {

  private int daysDuration;
  private String name;
  private String address;
  private String startDate;
  private String endDate;
  private int serialNumber;

  public DayPass( String n, String ad, int duration, int serial ) {

    name = n;
    address = ad;
    daysDuration = duration;

    serialNumber = serial;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "yyyy/MM/dd" );
    LocalDateTime timeStart = LocalDateTime.now();
    startDate = dtf.format( timeStart );
    endDate = dtf.format( timeStart.plusDays(duration));
  }

  public int getSerialNumber() {
    return serialNumber;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getEnd() {
    return startDate;
  }

  public void print() {
    System.out.println( "Pass informatin\n" );

    System.out.println( "Name: " + name );
    System.out.println( "Serial Number: " + serialNumber );
    System.out.println( "Start Date: " + startDate );
    System.out.println( "Start Date: " + endDate);
  }
}
