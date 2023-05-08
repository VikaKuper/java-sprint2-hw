import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class MonthlyReport {
    public ArrayList<Items> items = new ArrayList<>();

    String readFileContents(String path) {

        try {

            return Files.readString(Path.of(path));

        } catch (IOException e) {

            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");

            return Collections.emptyList().toString();

        }

    }



    public void toItem(String month, String path){
        String content = readFileContents(path);

        String[] lines = content.split("\r?\n");

        for (int i = 1; i < lines.length; i++){

            String line = lines[i];

            String[] parts = line.split(",");

            Items item = new Items(month, parts[0], Boolean.parseBoolean(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));

            items.add(item);

        }


    }

    public void getInfoOfItemInJanuary(){

        if (items.size() == 0){

            System.out.println("Отчёты не были считаны");

            System.exit(0);

        }

        Items max = null;

        Items min = null;

        int totalOfMax = 0;

        int totalOfMin = 0;

        for (Items item : items) {
            if (item.months == "january") {

                if (item.isExpense) {

                    continue;

                }

                if (item.getFinalSum() > totalOfMax) {

                    totalOfMax = item.getFinalSum();

                    max = item;

                }

            }
        }

        for (Items item : items) {
            if (item.months == "january") {

                if (item.isExpense) {

                    if (item.getFinalSum() > totalOfMin) {

                        totalOfMin = item.getFinalSum();

                        min = item;

                    }

                }

            }
        }

        System.out.println("Январь: \nСамый прибыльный товар: " + max.name + " " + max.getFinalSum() + "\nСамая большая трата: " + min.name + " " + min.getFinalSum());

    }

    public void getInfoOfItemInFebruary(){

        if (items.size() == 0){

            System.out.println("Отчёты не были считаны");

            System.exit(0);

        }

        Items max = null;

        Items min = null;

        int totalOfMax = 0;

        int totalOfMin = 0;

        for (Items item : items) {
            if (item.months == "february") {

                if (item.isExpense) {

                    continue;

                }

                if (item.getFinalSum() > totalOfMax) {

                    totalOfMax = item.getFinalSum();

                    max = item;

                }

            }
        }

        for (Items item : items) {
            if (item.months == "february") {

                if (item.isExpense) {

                    if (item.getFinalSum() > totalOfMin) {

                        totalOfMin = item.getFinalSum();

                        min = item;

                    }

                }

            }
        }

        System.out.println("Февраль: \nСамый прибыльный товар: " + max.name + " " + max.getFinalSum() + "\nСамая большая трата: " + min.name + " " + min.getFinalSum());

    }



    public void getInfoOfItemInMarch(){

        if (items.size() == 0){

            System.out.println("Отчёты не были считаны");

            System.exit(0);

        }

        Items max = null;

        Items min = null;

        int totalOfMax = 0;

        int totalOfMin = 0;

        for (Items item : items) {
            if (item.months == "march") {

                if (item.isExpense) {

                    continue;

                }

                if (item.getFinalSum() > totalOfMax) {

                    totalOfMax = item.getFinalSum();

                    max = item;

                }

            }
        }

        for (Items item : items) {
            if (item.months == "march") {

                if (item.isExpense) {


                    if (item.getFinalSum() > totalOfMin) {

                        totalOfMin = item.getFinalSum();

                        min = item;

                    }

                }

            }
        }

        System.out.println("Март: \nСамый прибыльный товар: " + max.name + " " + max.getFinalSum() + "\nСамая большая трата: " + min.name + " " + min.getFinalSum());

    }

}