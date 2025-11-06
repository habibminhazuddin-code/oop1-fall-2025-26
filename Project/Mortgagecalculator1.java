   
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
 
public class Mortgagecalculator1 {
    public static void main(String[] args) {
        System.out.println("=== Bangladesh Mortgage Calculator (Dollar) ===");
        Scanner sc = new Scanner(System.in);

        

                if (sc.hasNextDouble()) {
    double num = sc.nextDouble();
    System.out.println(" You entered: " + num);
} else {
    System.out.println(" Invalid input! Please enter numbers only.");
}
            

            

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter Your credit score (0-500) :");
        int creditScore = sc.nextInt();
        System.out.print("do you have any criminal record (True/False) :");
        boolean criminalRecord = sc.nextBoolean();

        if (creditScore < 0 || creditScore > 500) {
                System.out.println("Credit Score must be between 0 and 500.");
                
            }

            // Loan Eligibility Check
            if (salary <= 0 || creditScore < 300 || criminalRecord) {
                System.out.println(" You are not eligible for a loan.");
                System.out.println("Reason:");
                if (salary <= 0) System.out.println("- Salary must be greater than 0.");
                if (creditScore < 300) System.out.println("- Credit score must be at least 300.");
                if (criminalRecord) System.out.println("- Applicant must not have a criminal record.");}
                
        System.out.print("Enter loan amount (principal in BDT): ");
        int num = sc.nextInt();
        if(num > 2* salary){
            System.out.println("loan amount cannot exceed your twice salary");
        }
 
        System.out.print("Enter annual interest rate: ");
        float num2 = sc.nextFloat();
 
        System.out.print("Enter loan period (in years): ");
        int num3 = sc.nextInt();
 
        float r = (num2 / 100 / 12);  
        int n = num3 * 12;          
 
        double m = (double) num * (r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        double totalPayment = m * n;
        double totalInterest = totalPayment - num;
        Locale bdLocale= Locale.of("en","BD");
         
         
        System.out.println("=== Mortgage Summary ===");
 
       
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(bdLocale);
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

 

