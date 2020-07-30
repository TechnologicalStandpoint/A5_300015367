import pass.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Authenticator {

  Database db;
  Authenticator auth;

  public Authenticator( Database thisDatabase ) {
    db = thisDatabase;
    auth = new Authenticator( db );
  }

  public Boolean validSerialNumber( int ID ) {
    try {

      db.find( ID );
      return true;
    }

    catch( IndexOutOfBoundsException ex ) {
      System.out.println( "Not a valid ticket!" );

      return false;
    }
  }

  public Boolean validExpirationDate( Pass pass ) {

    LocalDateTime now = LocalDateTime.now();
    if ( now.isAfter( pass.getEnd() ) ) {
      System.out.println( "This pass has expired" );
      return false;
    }

    else return true;
  }

  public Boolean authenticate( int id ) {

    Pass p = db.find(id);

    return validSerialNumber( id ) && validExpirationDate( p );
  }

}
