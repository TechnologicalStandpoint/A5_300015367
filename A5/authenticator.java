// Project: A5_300015367
// Copyright (c) 2020 William Kennedy
/*
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
import pass.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/*
  An authenticator class used to determine the validity of each DayPass and
  Seasons Pass.
*/

public class Authenticator {

  Database db;

  public Authenticator( Database thisDatabase ) {
    db = thisDatabase;
  }

  //Checks that the ticket with serial number ID is contained within the
  //database.
  // @param ID- serial number of the ticket

  public Boolean validSerialNumber( int ID ) {
    try {

      db.find( ID );
      return true;
    }

    catch( IndexOutOfBoundsException ex ) {
      System.out.println( "Not a valid serial number!" );

      return false;
    }
  }

  // Check the expiration date of each ticket
  // @param pass- ticket to check
  public Boolean validExpirationDate( Pass pass ) {

    LocalDateTime now = LocalDateTime.now();
    if ( now.isAfter( pass.getEnd() ) ) {
      System.out.println( "This pass has expired" );
      return false;
    }

    else return true;
  }
  // Method that checks the validity of the expiration date and serial number
  // @param id- serial number of the ticket
  //
  public Boolean authenticate( int id ) {

    Pass p = db.find(id);

    return validSerialNumber( id ) && validExpirationDate( p );
  }

}
