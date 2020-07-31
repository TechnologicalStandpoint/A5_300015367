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

/*
  This file contains the data structure that contains all the passes that have been
  created, it allows for the creation and deletion of new passes.  Holds the
  object that authenticates each ticket.
*/


public class Database {

  private ArrayList<Pass> db;
  private int serial;
  private Authenticator auth;

  public Database() {

    db = new ArrayList<>();

    auth = new Authenticator(this);

    serial = 0;

  }

  /* Creates a new DayPass and add its to the database within the system.

     @param name- The name of the ticket holder
     @param address- The address of the ticket holder
     @param duration- The length in days that the ticket will be valid

  */

  public DayPass newDayPass( String name, String address, int duration ) {

    if ( checkDuration( duration ) ) {

      DayPass newPass = new DayPass( name, address, duration, serial );

      if (auth.validExpirationDate(newPass)) {
        db.add( newPass );
        serial++;
        System.out.println( name + " has a new "+Integer.toString( duration ) + " day ticket! Enjoy the slopes!" );
        return newPass;
      }
      else {
        System.out.println("Not a valid expiration date.  Deleting pass");
      }


    }

    System.out.println( "Duration of the ticket must be between 0 and 3." +
    "  Try again or buy a seasons pass" );
    return null;
  }

  /* Creates a new SeasonsPass and adds it to the database

     @param name- The name of the ticket holder
     @param address- The address of the ticket holder
  */

  public SeasonsPass newSeasonsPass( String name, String address ) {

    SeasonsPass newPass = new SeasonsPass( name, address, serial );

    if (auth.validExpirationDate(newPass)) {

      db.add( newPass );
      serial++;
      System.out.println( name + " has a new Seasons Pass! Enjoy the slopes!" );
      return newPass;
    }

    else {
      System.out.println("Not a valid expiration date.  Deleting pass");
      return null;
    }


  }

  /* Removes the pass from the database

     @param p- Pass to be removed from the database
  */

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

  /* Finds a specific pass in the database

     @param ID- The serial number of the ticket they want to find
  */
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

  /* Method used when creating a new DayPass, it makes sure that the length of
     the ticket is greater than 0 and less than 4.  Returning false otherwise.

     @param dur- The length specified by the user
  */
  public Boolean checkDuration( int dur ) {
    if ( dur > 0 && dur < 4 ) {
      return true;
    }

    else return false;
  }

  /* A method accepting input from the commandline, acting as the user interface.
     Allows the user to call methods.
     Taking the barebone structure of the accept method in Assignment 1, file
     ClientConsole.java to properly implement the flow of logic for the input
  */
  public void accept() {

      String message;
      try {

        BufferedReader fromConsole = new BufferedReader( new InputStreamReader( System.in ) );


        while (true) {
          System.out.println( "\nEnter a command" );

          message = fromConsole.readLine();

          switch ( message ) {
            //Case for making a new Pass
            case "NewPass":
              System.out.println( "\nEnter the persons name" );
              String name = fromConsole.readLine();

              System.out.println( "\nEnter the address" );
              String address = fromConsole.readLine();

              Boolean flagOne = true;

              while ( flagOne ) {

                System.out.println( "\nEnter the type of Pass" );
                message = fromConsole.readLine();

                //Creation of a Day Pass
                if ( message.equals( "Day Pass" ) ) {


                  System.out.println( "\nEnter the duration of the pass" );
                  Boolean flagTwo = true;

                  int duration = 0;
                  while ( flagTwo ) {
                    try {
                      duration = Integer.parseInt( fromConsole.readLine() );
                      DayPass newPass = newDayPass( name, address, duration );
                      flagTwo = false;

                    }

                    catch ( Exception ex ) {
                      System.out.println( "Must enter an integer.  Try again" );
                    }
                  }


                  flagOne = false;
                }

                //Creation of a Seasons Pass
                else if ( message.equals( "Seasons Pass" ) ) {
                  SeasonsPass newPass = newSeasonsPass( name, address );
                  flagOne = false;
                }
              }
              break;

            //Case to authenticate a ticket
            case "Authenticate":
              System.out.println( "Enter Serial Number " );

              Boolean integer = true;

              while (integer) {
                message = fromConsole.readLine();

                try {
                  int i = Integer.parseInt( message );
                  integer = false;
                }

                catch ( Exception ex ) {
                  System.out.println( "You must enter a valid integer" );
                }
              }

              if ( auth.authenticate( Integer.parseInt( message ) ) ) {
                System.out.println( "This is a valid ticket" );
                this.find( Integer.parseInt(message) ).print();
              }

              else {
                System.out.println( "This is an invalid ticket" );
              }

              break;

            //Case to get information about specific ticket
            case "GetInformation":

              Boolean flag = true;
              while (flag) {

                System.out.println( "Enter the Serial number of the ticket holder" );
                message = fromConsole.readLine();

                try {
                  Pass get = find( Integer.parseInt( message ) );
                  get.print();
                }

                catch (Exception e) {
                  System.out.println( "\nInvalid input" );
                }

            }
              break;

            default:
              System.out.println( "\nInvalid command.  Try again" );
          }
        }
      }

      catch( Exception ex ) {

      }
  }

}
