package pass;
/* An interface for a ticket, where each subclass is a slight variant
   each with a unique serial number
*/

import java.time.LocalDateTime;

public interface Pass {



  public int getSerialNumber();

  public String getName();

  public String getAddress();

  public void print();

  public LocalDateTime getEnd();
}
