package com.exercise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    private void menu() throws IOException {

        log.info("Wybierz co chcesz zrobic: \n{}\n{}\n{}\nTIP: Zeby wywolac ktoras z akcji wcisnij 1,2 lub 3 na klawiaturze!", "[1] - Utworz folder", "[2] - Dodaj nowy plik ze statystykami", "[3] - Zamknij program");
        Scanner sc = new Scanner(System.in);
        SaveToFile savetoFile = new SaveToFile();

        try {
            switch (sc.nextInt()) {
                case 1:
                    savetoFile.createNewFolder();
                    menu();
                case 2:
                    savetoFile.wordOn();
                    log.info("Stworzono nowy plik ze statystykami :)");
                    menu();
                case 3:
                    closeProgram();
                default:
                    log.warn("Wpisales cos innego niz 1,2 lub 3! Wpisz pomownie!");
                    menu();
            }
        } catch (InputMismatchException e) {
            log.warn("Wpisales cos innego niz 1,2 lub 3! Wpisz pomownie!");
            menu();
        }
    }

    private void closeProgram() {
        System.exit(1);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.menu();
    }
}