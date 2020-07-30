import pass.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class authenticate {

  database dbb;

  public authenticate(database db) {
    dbb = db;
  }

  public Boolean validSerialNumber(int ID) {
    try {

      dbb.find(ID);
      return true;
    }

    catch(IndexOutOfBoundsException ex) {
      System.out.println("Not a valid ticket!");

      return false;
    }
  }

  public Boolean validExpirationDate(int ID) {

    Pass pass = dbb.find(ID);

    LocalDateTime now = LocalDateTime.now();
    return true;
    /*if (now.isAfter(ID.getEnd())) {

    }*/
  }

}
