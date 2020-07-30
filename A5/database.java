// @author William Kennedy
// License
import pass.*;
import java.io.*;
import java.util.ArrayList;


public class database {

  private ArrayList<Pass> dayPass;
  private ArrayList<Pass> seasonsPass;
  private ArrayList[] types;
  private int serial;

  public database() {

    types = new ArrayList[2];
    dayPass = new ArrayList<>();
    seasonsPass = new ArrayList<>();

    types[0] = dayPass;
    types[1] = seasonsPass;

    serial = 0;

  }

  public DayPass newDayPass( String name, String address, int duration ) {

    if ( checkDuration( duration ) ) {
      DayPass newPass = new DayPass( name, address, duration, serial );
      types[0].add( newPass );
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
    types[1].add(newPass);
    serial++;
    return newPass;
  }

  public Pass remove( Pass p ) {

    try {
      if ( p instanceof DayPass ) {
       types[0].remove( p );
     }

     else if ( p instanceof SeasonsPass ) {
       types[1].remove( p );
     }
   }

   catch ( Exception ex ) {
     System.out.println("This pass is not in our database");
   }

    return p;
  }

  public Pass find( int ID ) {
    Pass p;
    try {
      p = types[0].get( ID );
    }

    catch ( Exception ex ) {

      try {
        p = types[1].get( ID );
      }

      catch( Exception e ) {
        System.out.println( "This pass does not exist" );
      }
    }

    return p;
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

              if ( message.equals( "DayPass" ) ) {

                System.out.println( "\nEnter the duration of the pass" );
                Boolean flag = true;

                int duration = 0;
                while ( flag ) {
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
                SeasonsPass newPass = newSeasonsPass(name, address);
              }
              break;

            case "Authenticate":
              System.out.println( "Enter Serial Number \n" );

              break;

            case "GetInformation":
              System.out.println( "Enter the Serial number of the ticket holder" );

              break;
          }
        }
      }

      catch( Exception ex ) {

      }
  }

}
