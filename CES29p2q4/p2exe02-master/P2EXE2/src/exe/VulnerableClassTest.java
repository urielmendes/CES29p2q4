package exe;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.Test;

public class VulnerableClassTest {

  private VulnerableClass vuln;
  private String file;

  @Test(expected = Exception.class)
  public final void invalidFileNameTest() throws Exception {
    vuln = new VulnerableClass();
    file = "calção";
    vuln.vulnerableMethod(file);
  }

  @Test
  public final void userInputTest() {
    vuln = new VulnerableClass();
    String input = "calção";
    InputStream in = System.in;
    try {
      System.setIn(new ByteArrayInputStream(input.getBytes()));
      Scanner scan = new Scanner(System.in);
      System.out.println(scan.nextLine());
    } finally {
      System.setIn(in);
    }
    System.setIn(in);
  }
}
