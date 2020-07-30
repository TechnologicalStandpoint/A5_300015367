// Project: A5_300015367
// Copyright (c) 2020 William Kennedy
/*
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
import pass.*;
import java.io.*;
import java.util.ArrayList;


public class Database {

  private ArrayList<Pass> db;
  private int serial;

  public Database() {

    db = new ArrayList<>();

    serial = 0;

  }

  public DayPass newDayPass( String name, String address, int duration ) {

    if ( checkDuration( duration ) ) {
      DayPass newPass = new DayPass( name, address, duration, serial );
      db.add( newPass );
      serial++;

      System.out.println( name + " has a new "+Integer.toString( duration ) + " day ticket! Enjoy the slopes!" );
      return newPass;
    }

    System.out.println( "Duration of the ticket must be between 0 and 3." +
    "  Try again or buy a seasons pass" );
    return null;
  }

  public SeasonsPass newSeasonsPass( String name, String address ) {
    SeasonsPass newPass = new SeasonsPass( name, address, serial );
    db.add( newPass );
    serial++;
    System.out.println( name + " has a new Seasons Pass! Enjoy the slopes!" );
    return newPass;
  }

  public Pass remove( Pass p ) {

   try {
      db.remove( p );
      return p;
   }
   catch ( Exception ex ) {
     System.out.println("This pass is not in our database");
   }
   return null;
  }

  public Pass find( int ID ) {
    Pass p;
    try {
      p = db.get( ID );
      return p;
    }

    catch ( Exception ex ) {

      System.out.println( "This pass does not exist" );
      return null;
    }
  }

  public Boolean checkDuration( int dur ) {
    if ( dur > 0 && dur < 4 ) {
      return true;
    }

    else return false;
  }

  public void accept() {

      String message;
      try {

        BufferedReader fromConsole = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.println( "\nEnter a command" );

        while (true) {

          message = fromConsole.readLine();

          switch ( message ) {

            case "NewPass":
              System.out.println( "\nEnter the persons name" );
              String name = fromConsole.readLine();

              System.out.println( "\nEnter the address" );
              String address = fromConsole.readLine();

              System.out.println( "\nEnter the type of Pass" );
              message = fromConsole.readLine();

              Boolean flagOne = true;

              while ( flagOne ) {

                if ( message.equals( "DayPass" ) ) {

                  System.out.println( "\nEnter the duration of the pass" );
                  Boolean flagTwo = true;

                  int duration = 0;
                  while ( flagTwo ) {
                    try {
                      duration = Integer.parseInt( fromConsole.readLine() );
                      flag = false;
                    }

                    catch ( Exception ex ) {
                      System.out.println( "Must enter an integer.  Try again" );
                    }
                  }

                  DayPass newPass = newDayPass( name, address, duration );
                }

                else if ( message.equals( "Seasons Pass" ) ) {
                  SeasonsPass newPass = newSeasonsPass( name, address );
                }
              }
              break;

            case "Authenticate":
              System.out.println( "Enter Serial Number \n" );

              message = fromConsole.readLine();

              auth.authenticate( Integer.parseInt( message ) );

              break;

            case "GetInformation":
              System.out.println( "Enter the Serial number of the ticket holder" );
              message = fromConsole.readLine();

              Pass get = find(Integer.parseInt(message));
              get.print();
              break;
          }
        }
      }

      catch( Exception ex ) {

      }
  }

}
