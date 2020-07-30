import pass.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class authenticator {

  database db;

  public authenticator(database thisDatabase) {
    db = thisDatabase;
  }

  public Boolean validSerialNumber(int ID) {
    try {

      db.find(ID);
      return true;
    }

    catch(IndexOutOfBoundsException ex) {
      System.out.println("Not a valid ticket!");

      return false;
    }
  }

  public Boolean validExpirationDate(int ID) {

    Pass pass = db.find(ID);

    LocalDateTime now = LocalDateTime.now();
    return true;
    /*if (now.isAfter(ID.getEnd())) {

    }*/
  }

}
