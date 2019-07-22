
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {


    public void menu() throws IOException {

        System.out.print("\nWybierz co chcesz zrobic:\n[1] - Utworz folder \n[2] - Dodaj nowy plik ze statystykami\n[3] - Zamknij program\n\nTIP: Zeby wywolac któras z akcji wcisnij 1,2 lub 3 na klawiaturze!\n\n");
        Scanner sc = new Scanner(System.in);
        SaveToFile savetoFile = new SaveToFile();

        try {
            switch (sc.nextInt()) {
                case 1:
                    savetoFile.createNewFolder();
                    menu();
                case 2:
                    savetoFile.wordOn();
                    menu();
                case 3:
                    closeProgram();
                default:
                    System.out.println("Wpisa³eœ coœ innego ni¿ 1,2 i 3 :( Wpisz ponownie!");
                    menu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Wpisa³eœ coœ innego ni¿ 1,2 i 3 :( Wpisz ponownie!");
            menu();
        }

    }


    public void closeProgram() {
        System.exit(1);
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.menu();
    }


}