// @author William Kennedy
// license:
package pass;


import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class SeasonsPass implements Pass {

  private String address;
  private String name;
  private String startDate;
  private String endDate;
  private int serialNumber;

  public SeasonsPass( String n, String a ) {

    name = n;
    address = a;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "yyyy/MM/dd" );
    LocalDateTime timeStart = LocalDateTime.now();
    startDate = dtf.format( timeStart );
    endDate = "2021/04/31";

    serialNumber = ( int ) ( Math.random() * 100000 );
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
    return endDate;
  }

  public void print() {
    System.out.println( "Pass informatin\n" );

    System.out.println( "Name: " + name );
    System.out.println( "Serial Number: " + serialNumber );
    System.out.println( "Start Date: " + startDate );
    System.out.println( "Start Date: " + endDate );
  }
}
