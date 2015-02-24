import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

public class LoadTestResource {

  @Test
  public void load() {
    assertNotNull(getClass().getResource("test.txt"));
  }

}
