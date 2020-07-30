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
  private String start;
  private String end;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private int serialNumber;

  public DayPass( String n, String ad, int duration, int serial ) {

    name = n;
    address = ad;
    daysDuration = duration;

    serialNumber = serial;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "MM/dd/yyyy" );
    startDate = LocalDateTime.now();
    endDate = startDate.plusDays( duration );

    start = dtf.format( startDate );
    end = dtf.format( endDate );

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

  public LocalDateTime getEnd() {
    return endDate;
  }

  public void print() {
    System.out.println( "Pass informatin\n" );

    System.out.println( "Name: " + name );
    System.out.println( "Serial Number: " + serialNumber );
    System.out.println( "Start Date: " + start );
    System.out.println( "Start Date: " + end);
  }
}
