import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MonthlyReport {
    public HashMap<Integer,String> manager = new HashMap<>();
    public ArrayList<Items> items01 = new ArrayList<>();
    public ArrayList<Items> items02 = new ArrayList<>();
    public ArrayList<Items> items03 = new ArrayList<>();
    public void MonthlyReport() throws IOException {

        for (int i = 1; i <= 3; i++){
            String file = "resources/m.20210" + i +".csv";
            String contentOfMonth = readFileContents(file);
            manager.put(i,contentOfMonth);
        }
    }

    String readFileContents(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList().toString();
        }
    }

    public void toItem(){
        String[] lineContents01 = manager.get(1).split("\r?\n");
            for (int i = 1; i < lineContents01.length; i++){
                String line = lineContents01[i];
                String[] parts = line.split(",");
                Items item = new Items(parts[0], Boolean.parseBoolean(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                items01.add(item);
            }
        String[] lineContents02 = manager.get(2).split("\r?\n");
        for (int i = 1; i < lineContents02.length; i++){
            String line = lineContents02[i];
            String[] parts = line.split(",");
            Items item = new Items(parts[0], Boolean.parseBoolean(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
            items02.add(item);
        }
        String[] lineContents03 = manager.get(3).split("\r?\n");
        for (int i = 1; i < lineContents03.length; i++){
            String line = lineContents03[i];
            String[] parts = line.split(",");
            Items item = new Items(parts[0], Boolean.parseBoolean(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
            items03.add(item);
        }
    }
    public void getInfoOfItemInJanuary(){
        Items max = null;
        Items min = null;
        int totalOfMax = 0;
        int totalOfMin = 0;
        for (Items item : items01) {
            if (item.isExpense) {
                continue;
            }
            if (item.getFinalSum() > totalOfMax) {
                totalOfMax = item.getFinalSum();
                max = item;
            }
        }
        for (Items item : items01){
            if(item.isExpense){
                if (item.getFinalSum() > totalOfMin){
                    totalOfMin = item.getFinalSum();
                    min = item;
                }
            }
        }
        System.out.println("Январь: \nСамый прибыльный товар: " + max.name + " " + max.getFinalSum() + "\nСамая большая трата: " + min.name + " " + min.getFinalSum());
    }
    public void getInfoOfItemInFebruary(){
        Items max = null;
        Items min = null;
        int totalOfMax = 0;
        int totalOfMin = 0;
        for (Items item : items02) {
            if (item.isExpense) {
                continue;
            }
            if (item.getFinalSum() > totalOfMax) {
                totalOfMax = item.getFinalSum();
                max = item;
            }
        }
        for (Items item : items02){
            if(item.isExpense){
                if (item.getFinalSum() > totalOfMin){
                    totalOfMin = item.getFinalSum();
                    min = item;
                }
            }
        }
        System.out.println("Февраль: \nСамый прибыльный товар: " + max.name + " " + max.getFinalSum() + "\nСамая большая трата: " + min.name + " " + min.getFinalSum());
    }

    public void getInfoOfItemInMarch(){
        Items max = null;
        Items min = null;
        int totalOfMax = 0;
        int totalOfMin = 0;
        for (Items item : items03) {
            if (item.isExpense) {
                continue;
            }
            if (item.getFinalSum() > totalOfMax) {
                totalOfMax = item.getFinalSum();
                max = item;
            }
        }
        for (Items item : items03){
            if(item.isExpense){
                if (item.getFinalSum() > totalOfMin){
                    totalOfMin = item.getFinalSum();
                    min = item;
                }
            }
        }
        System.out.println("Март: \nСамый прибыльный товар: " + max.name + " " + max.getFinalSum() + "\nСамая большая трата: " + min.name + " " + min.getFinalSum());
    }
}

