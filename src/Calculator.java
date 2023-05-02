import java.util.ArrayList;
import java.util.HashMap;

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
        int profit01 = 0;
        int profit02 = 0;
        int profit03 = 0;
        int expenses01 = 0;
        int expenses02 = 0;
        int expenses03 = 0;
        int sumOfExpenses = 0;
        int sumOfProfit = 0;

        for (Items item : yearlyReport.items){
            if (item.month == 01){
                if (item.isExpense){
                    expenses01 = item.sum;
                    sumOfExpenses = expenses01;
                    continue;
                }else{
                    profit01 = item.sum;
                    sumOfProfit = profit01;
                }
            }
            if (item.month == 02){
                if (item.isExpense){
                    expenses02 = item.sum;
                    sumOfExpenses = sumOfExpenses + expenses02;
                }else{
                    profit02 = item.sum;
                    sumOfProfit = sumOfProfit + profit02;
                }
            }
            if (item.month == 03){
                if (item.isExpense){
                    expenses03 = item.sum;
                    sumOfExpenses = sumOfExpenses + expenses03;
                }else{
                    profit03 = item.sum;
                    sumOfProfit = sumOfProfit + profit03;
                }
            }
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

        if (sumOfProfitOfJanuary != profit01 || sumOfExpensesOfJanuary != expenses01) {
            System.out.println("Январь");
            answer = true;
        } else if (sumOfProfitOfFebruary != profit02 || sumOfExpensesOfFebruary != expenses02) {
            System.out.println("Февраль");
            answer = true;
        }else if (sumOfProfitOfMarch != profit03 || sumOfExpensesOfMarch != expenses03){
            System.out.println("Март");
            answer = true;
        }else System.out.println("Ошибок не найдено");
        return answer;
    }

}
