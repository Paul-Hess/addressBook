import org.junit.*;
import static org.junit.Assert.*;


public class AddressTest {

  @Test
  public void addressTest_instantiatesAddressCorrectly() {
    Address testAddress = new Address("222 two street", "portland", "OR", 97027);
    assertTrue(testAddress instanceof Address);
  }
}
