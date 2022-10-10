import Battle.Battle;
import Droid.*;

import PrintFile.Printer;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String value;
        do {
            System.out.println("1.Битва 1 на 1");
            System.out.println("2.Бій команда на команду ");
            System.out.println("3.Загрузити бій");
            System.out.println("4.Вихід\n");
            System.out.print("Твій вибір: ");
            value = scanner.nextLine();
            switch (value) {
                case "1" -> startBattle(1);
                case "2" -> {
                    System.out.println("Введіть розмір команди:");
                    startBattle(scanner.nextInt());
                }
                case "3" -> {
                    System.out.println("Введіь назву файлу");
                    String fileName = scanner.nextLine();
                    Printer.readFromFile(fileName);
                }
                case "4" -> System.out.println("Закінчення програми!");
            }

        } while (!value.equals("4"));

    }

    /**
     * Метод,що викликає метод start Main класу
     * @param size розмір команд дроїдів
     */


    private static void startBattle(int size) {
        Printer pr = null;
        System.out.println("Зберегти бій до вайлу? 1.Так/2.Ні: ");
        if (scanner.nextInt()== 1) {
            pr = new Printer("file.txt");
            Printer.setWriteToFile(true);
        } else {
            Printer.setWriteToFile(false);
        }
        start(size);
        if (Printer.getWriteToFile() && pr != null) {
            pr.closePrinter();
        }
    }
    /**
     * Метод для формування команд та запуску битви між ними
     * @param size розмір команд дроїдів
     */
    private static void start(int size){


        System.out.println("Формування першої команди");
        Team myTeam = new Team(size);
        System.out.println("Формування другої команди");
        Team enemyTeam = new Team(size);

        Battle battle = new Battle(myTeam, enemyTeam);
        battle.battle();
    }


}