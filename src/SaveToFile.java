import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveToFile {

    String dictionaryPath = "C:\\statistics";
    String filePath = "";

    void createNewFolder() {

        dictionaryPath = "C:\\statistics";
        File directory = new File(dictionaryPath);
        if (!directory.exists()) {
            directory.mkdir();
            this.dictionaryPath = dictionaryPath;
            System.out.println("Ustawiono domyslna sciezke C:\\statistics");
        } else {
            System.out.println("Folder o takiej nazwie już istnieje!");
        }
    }


    int wordsNumber = 0;
    String[] wordsList;
    int lettersNumber = 0;
    String longestWord;


    void wordOn() throws IOException {

        File directory = new File(dictionaryPath);

        if (!directory.exists()) {
            System.out.println("Pierw stworz folder na statystyki!");
            return;
        }


        File txtFile = null;
        int x = 1;
        boolean breaker = true;
        do {

            try {
                filePath = new StringBuilder().append(dictionaryPath).append("\\statystyka ").append(x).append(".txt").toString();
                txtFile = new File(filePath);

                if (!txtFile.exists()) {
                    txtFile.createNewFile();
                    breaker = false;
                } else {
                    x++;
                }
            } catch (Exception e) {
                System.out.println("dupa");
            }

        } while (breaker);


        System.out.println("Wpisz dowolne zdanie!");

        PrintWriter fileWriter = new PrintWriter(filePath);
        userInput();


        fileWriter.write("lista slow: ");

        for (int i = 0; i < wordsList.length; i++) {
            String test = wordsList[i] + ", ";
            fileWriter.write(test);
        }

        fileWriter.write("\r\nliczba slow: ");
        fileWriter.write(wordsNumber + "\r\n");
        fileWriter.write("liczba liter: ");
        fileWriter.write(lettersNumber + "\r\n");
        fileWriter.write("najdluzsze slowo: ");
        fileWriter.write(longestWord + "\r\n");
        fileWriter.close();


    }


    private void userInput() {

        Scanner sc = new Scanner(System.in);

        String userInput = sc.nextLine().trim();

        wordsList = userInput.split(" +");
        wordsNumber = wordsList.length;
        lettersNumber = userInput.replace(" ", "").length();
        longestWord = longestWordCaluclate(wordsList);

    }

    private String longestWordCaluclate(String[] string) {
        int y = string[0].length();
        String x = "";
        if (string.length == 1) {
            return string[0];
        } else
            for (int i = 1; i < string.length; i++)
                if (y < string[i].length()) {
                    x = string[i];
                    y = string[i].length();
                }
        return x;
    }

}