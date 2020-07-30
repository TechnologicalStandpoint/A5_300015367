// @author William Kennedy
// License
import pass.*;

import java.util.ArrayList;


public class mainSystem {

  public static void main(String [] args) {
    database db = new database();
    DayPass newPass = db.newDayPass("Will", "Calgary", 2);

    newPass.print();

    db.accept();
  }
}
