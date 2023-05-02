public class TipCalculator
{
    private double bill;
    private int tipPercentage;
    private int numberOfPeople;

    public TipCalculator(double bill, int tipPercentage, int numberOfPeople) {
        this.bill = bill;
        this.tipPercentage = tipPercentage;
        this.numberOfPeople = numberOfPeople;
    }

    public double getBill() {return bill;}
    public int getTip() {return tipPercentage;}
    public int getNumberOfPeople() {return numberOfPeople;}
    public void setBill(double newBill) {bill = newBill;}
    public void setTipPercentage(int newPercent) {tipPercentage = newPercent;}
    public void setNumberOfPeople(int newNumberOfPeople) {numberOfPeople = newNumberOfPeople;}

    public double calculateTip() {
        return bill*tipPercentage/100.0;
    }

    public double totalBill() {
        return bill + calculateTip();
    }

    public double tipPerPerson() {
        return calculateTip()/numberOfPeople;
    }

    public double totalPerPerson() {
        return bill/numberOfPeople + tipPerPerson();
    }
}