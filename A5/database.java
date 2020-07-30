// @author William Kennedy
// License
import pass.*;
import java.io.*;
import java.util.ArrayList;


public class database {

  private ArrayList<Pass> db;
  private int serial;

  public database() {

    db = new ArrayList<>();
    serial = 0;

  }

  public DayPass newDayPass(String name, String address, int duration) {
    DayPass newPass = new DayPass(name, address, duration, serial);
    serial++;
    return newPass;
  }

  public SeasonsPass newSeasonsPass(String name, String address) {
    SeasonsPass newPass = new SeasonsPass(name, address);
    serial++;
    return newPass;
  }

  public void add( Pass p ) {
    db.add( p );
  }

  public Pass remove( Pass p ) {
    db.remove( p );

    return p;
  }

  public Pass find( int ID ) {
    return db.get( ID );
  }

  public void accept() {

      String message;
      try {
        BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
        message = fromConsole.readLine();

        while (true) {
          switch (message) {

            case "NewPass":
              System.out.println("Enter the persons name");
              String name = fromConsole.readLine();

              System.out.println("Enter the address");
              String address = fromConsole.readLine();

              System.out.println("Enter the type of Pass");
              String pass = fromConsole.readLine();

              if ( pass == "Day Pass" ) {

                System.out.println("Enter the duration of the pass");
                Boolean flag = true;

                int duration = 0;
                while (flag) {
                  try {
                    duration = Integer.parseInt(fromConsole.readLine());
                    flag = false;
                  }

                  catch (Exception ex) {
                    System.out.println("Must enter an integer.  Try again");
                  }
                }

                DayPass newPass = new DayPass(name, address, duration, serial);
                System.out.println(name+" has a new "+Integer.toString(duration)+" pass! Enjoy the slopes!");
                newPass.print();
                serial++;
              }

              else if ( pass == "Seasons Pass") {

              }
              break;

            case "Authenticate":
              System.out.println( "Enter Serial Number \n");

              break;

            case "GetInformation":
              System.out.println("Enter the name or Serial number of the ticket holder");

              break;

          }
        }
      }

      catch(Exception ex) {

      }
  }

}
