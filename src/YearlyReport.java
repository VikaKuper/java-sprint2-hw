import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;


public class YearlyReport {
    public String contentOfYear;
    public ArrayList<Items> items = new ArrayList<>();
    public Calculator calculator = new Calculator();
    public int profit01 = 0;
    public int profit02 = 0;
    public int profit03 = 0;
    public int expenses01 = 0;
    public int expenses02 = 0;
    public int expenses03 = 0;


    public void YearlyReport() throws IOException {
        String file = "resources/y.2021.csv";
        contentOfYear = readFileContents(file);


    }

    String readFileContents(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList().toString();
        }
    }

    public void toItem() {
        String[] lineContents01 = contentOfYear.split("\r?\n");
        for (int i = 1; i < lineContents01.length; i++) {
            String line = lineContents01[i];
            String[] parts = line.split(",");
            Items item = new Items(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Boolean.parseBoolean(parts[2]));
            items.add(item);
        }
    }

    public void printInfo() {
        if (items.size() == 0) {
            System.out.println("Отчёт не был считан");
            System.exit(0);
        }
        int year = 2021;
        String month01 = null;
        String month02 = null;
        String month03 = null;
        int sumOfExpenses = 0;
        int sumOfProfit = 0;

        for (Items item : items) {
            if (item.month == 01) {
                month01 = "Январь";
                if (item.isExpense) {
                    expenses01 = item.sum;
                    sumOfExpenses = expenses01;
                    continue;
                } else {
                    profit01 = item.sum;
                    sumOfProfit = profit01;
                }
            }
            if (item.month == 02) {
                month02 = "Февраль";
                if (item.isExpense) {
                    expenses02 = item.sum;
                    sumOfExpenses = sumOfExpenses + expenses02;
                } else {
                    profit02 = item.sum;
                    sumOfProfit = sumOfProfit + profit02;
                }
            }
            if (item.month == 03) {
                month03 = "Март";
                if (item.isExpense) {
                    expenses03 = item.sum;
                    sumOfExpenses = sumOfExpenses + expenses03;
                } else {
                    profit03 = item.sum;
                    sumOfProfit = sumOfProfit + profit03;
                }
            }
        }
        System.out.println("Год: " + year);
        System.out.println("Месяц: " + month01 + "\nПрибыль: " + (profit01 - expenses01) + "\nМесяц: " + month02 + "\nПрибыль: "
                + (profit02 - expenses02) + "\n Месяц: " + month03 + "\nПрибыль: " + (profit03 - expenses03));
        System.out.println("Средний расход за все месяцы: " + sumOfExpenses + "\nСредний доход за все месяцы: "
                + sumOfProfit);
    }

}