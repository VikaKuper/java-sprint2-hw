import java.util.ArrayList;


public class Calculator {
    public MonthlyReport monthlyReport;
    public YearlyReport yearlyReport;


    public Calculator(MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        this.monthlyReport = monthlyReport;
        this.yearlyReport = yearlyReport;
    }
    public Calculator(){

    }

    public boolean check() {
        if (yearlyReport.items.size() == 0 || monthlyReport.items01.size() == 0 || monthlyReport.items02.size() == 0 || monthlyReport.items03.size() == 0){
            System.out.println("Отчёты не были считаны");
            System.exit(0);
        }
        if (yearlyReport.profit01 == 0 || yearlyReport.expenses01 == 0 || yearlyReport.profit02 == 0 ||
                yearlyReport.expenses02 == 0 || yearlyReport.profit03 == 0 || yearlyReport.expenses03 == 0){
            System.out.println("Информация об отчетах не была выведена.");
            System.exit(0);
        }

        ArrayList<Items> january = new ArrayList<>(monthlyReport.items01);
        ArrayList<Items> february = new ArrayList<>(monthlyReport.items02);
        ArrayList<Items> march = new ArrayList<>(monthlyReport.items03);

        int sumOfProfitOfJanuary = 0;
        int sumOfProfitOfFebruary = 0;
        int sumOfProfitOfMarch = 0;
        int sumOfExpensesOfJanuary = 0;
        int sumOfExpensesOfFebruary = 0;
        int sumOfExpensesOfMarch = 0;
        boolean answer = false;

        for (Items item : january) {
            if (item.isExpense) {
                sumOfExpensesOfJanuary = sumOfExpensesOfJanuary + item.quantity * item.price;
            } else sumOfProfitOfJanuary = sumOfProfitOfJanuary + item.quantity * item.price;
        }
        for (Items item : february) {
            if (item.isExpense) {
                sumOfExpensesOfFebruary = sumOfExpensesOfFebruary + item.quantity * item.price;
            } else sumOfProfitOfFebruary = sumOfProfitOfFebruary + item.quantity * item.price;
        }
        for (Items item : march) {
            if (item.isExpense) {
                sumOfExpensesOfMarch = sumOfExpensesOfMarch + item.quantity * item.price;
            } else sumOfProfitOfMarch = sumOfProfitOfMarch + item.quantity * item.price;
        }

        if (sumOfProfitOfJanuary != yearlyReport.profit01 ||
                sumOfExpensesOfJanuary != yearlyReport.expenses01) {
            System.out.println("Январь");
            answer = true;
        } else if (sumOfProfitOfFebruary != yearlyReport.profit02 ||
                sumOfExpensesOfFebruary != yearlyReport.expenses02) {
            System.out.println("Февраль");
            answer = true;
        } else if (sumOfProfitOfMarch != yearlyReport.profit03 ||
                sumOfExpensesOfMarch != yearlyReport.expenses03) {
            System.out.println("Март");
            answer = true;
        } else System.out.println("Ошибок не найдено");

        return answer;
    }

}
