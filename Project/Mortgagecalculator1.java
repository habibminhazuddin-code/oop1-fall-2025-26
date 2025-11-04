
    
import java.text.NumberFormat;
import java.util.Scanner;
 
public class Mortgagecalculator1 {
    public static void main(String[] args) {
        System.out.println("=== Bangladesh Mortgage Calculator (Dollar) ===");
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Enter loan amount (principal in BDT): ");
        int num = sc.nextInt();
 
        System.out.print("Enter annual interest rate: ");
        float num2 = sc.nextFloat();
 
        System.out.print("Enter loan period (in years): ");
        int num3 = sc.nextInt();
 
        float r = (num2 / 100 / 12);  
        int n = num3 * 12;          
 
        double m = (double) num * (r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        double totalPayment = m * n;
        double totalInterest = totalPayment - num;


        System.out.println("=== Mortgage Summary ===");
 
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormatter = NumberFormat.getInstance();
 
        String formattedLoan = currencyFormatter.format(num);
        String formattedMonthly = currencyFormatter.format(m);
        String formattedTotal = currencyFormatter.format(totalPayment);
        String formattedInterest = currencyFormatter.format(totalInterest);
        String formattedRate = percentFormatter.format(num2);
 
        System.out.println("Loan Amount: " + formattedLoan);
        System.out.println("Annual Interest Rate: " + formattedRate + "%");
        System.out.println("Monthly Payment: " + formattedMonthly);
        System.out.println("Total Payment: " + formattedTotal);
        System.out.println("Total Interest: " + formattedInterest);
        sc.close();
    }
 
}
 

