public class Items {
    public String name;
    public boolean isExpense;
    public int quantity;
    public int price;
    public int month;
    public int sum;

    public Items(String name, boolean expense, int quantity, int price) {
        this.name = name;
        this.isExpense = expense;
        this.quantity = quantity;
        this.price = price;
    }
    public Items(int month, int sum, boolean isExpense){
        this.month = month;
        this.sum = sum;
        this.isExpense = isExpense;
    }

    public int getFinalSum(){
        int sum = quantity * price;
        return sum;
    }


}
