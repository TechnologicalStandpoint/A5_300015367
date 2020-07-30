// Project: A5_300015367
// Copyright (c) 2020 William Kennedy
/*
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package pass;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class SeasonsPass implements Pass {

  private String address;
  private String name;
  private String startDate;
  private String endDate;
  private int serialNumber;

  public SeasonsPass( String n, String a, int serial ) {

    name = n;
    address = a;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "yyyy/MM/dd" );
    LocalDateTime timeStart = LocalDateTime.now();
    startDate = dtf.format( timeStart );
    endDate = "2021/04/31";

    serialNumber = serial;
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
