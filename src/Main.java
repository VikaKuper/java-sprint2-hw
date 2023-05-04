import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // Поехали!
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Calculator calculator = new Calculator(monthlyReport, yearlyReport);


        while (true){
            printMenu();
            int command = scanner.nextInt();

            if (command == 1){
                monthlyReport.MonthlyReport();
                monthlyReport.toItem();

            }else if (command == 2){
                yearlyReport.YearlyReport();
                yearlyReport.toItem();

            }else if (command == 3){
                boolean answer = calculator.check();
                System.out.println("Результат проверки: " + answer);

            }else if (command == 4){
                monthlyReport.getInfoOfItemInJanuary();
                monthlyReport.getInfoOfItemInFebruary();
                monthlyReport.getInfoOfItemInMarch();

            }else if (command == 5){
                yearlyReport.printInfo();
            }else if (command == 0){
                System.out.println("Выход");
                break;
            }else {
                System.out.println("Извините, такой команды пока нет.");
            }

        }
    }
    public static void printMenu(){
        System.out.println("Введите комманду:");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}

