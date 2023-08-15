package mortage.test;

public class Counter {
    
    public double getMortage(double totalLoan,double yearlyInterest, int years){
        int months = years * 12;

        double monthlyIntrest = yearlyInterest/100/12; //Convert yearly interest to monthly interest as decimal number

        double monthlyPayment = totalLoan*(monthlyIntrest*power((1 + monthlyIntrest),months))/(power((1 + monthlyIntrest),months) - 1);

        return getRoundedNumber(monthlyPayment);
    }

    
    //The power and round number functions are only used by the Counter class and stays private, which is why they are not included in the test application

    private double power(double base, int exponent){
        double result = 1;
        for (int i = 0; i < exponent;i++){
            result = result * base;
        }

        return result;
    }

    private double getRoundedNumber(double number){
  
        return (double) ((int) (number*100+0.5))/100;
    }
}
