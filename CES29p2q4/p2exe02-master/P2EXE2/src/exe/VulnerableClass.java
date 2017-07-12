package exe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VulnerableClass {

  public final void vulnerableMethod(final String filename)
      throws Exception {

    Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
    Matcher matcher = pattern.matcher(filename);
    if (matcher.find()) {
      throw new Exception("Invalid characters");
    }
    boolean run = true;

    while (run) {

      Scanner console = new Scanner(System.in);
      System.out.println("Digite uma operação:");
      System.out.println("R para ler um arquivo\n");
      System.out.println("W para escrever em um arquivo\n");
      System.out.println("Ou digite S para sair");

      String opr = console.nextLine();

      if (opr.equals("R")) {
        BufferedReader br = null;
        FileReader fr = null;

        try {

          fr = new FileReader(filename);
          br = new BufferedReader(fr);

          String stCurrentLine;

          br = new BufferedReader(fr);

          while ((stCurrentLine = br.readLine())
              != null) {
            System.out.println(stCurrentLine);
          }

        } catch (IOException e) {
          e.printStackTrace();
        }
      } else if (opr.equals("W")) {
        BufferedWriter buffWrite;

        try {
          buffWrite = new BufferedWriter(new FileWriter(filename));
          String linha = "";
          System.out.println("Escreva algo: ");
          linha = console.nextLine();
          buffWrite.append(linha + "\n");
          buffWrite.flush();

        } catch (IOException e) {
          e.printStackTrace();
        }
      } else if (opr.equals("S")) {
        run = false;
        console.close();
      } else {
        System.out.println("Operação inválida, "
            + "digite novamente.");
      }
    }
  }
}
