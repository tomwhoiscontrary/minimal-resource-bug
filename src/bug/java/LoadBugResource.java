import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

public class LoadBugResource {

  @Test
  public void load() {
    assertNotNull(getClass().getResource("bug.txt"));
  }

}
