
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
 
public class Mortgagecalculator1 {
    public static void main(String[] args) {
        System.out.println("=== Bangladesh Mortgage Calculator (Dollar) ===");
        Scanner sc = new Scanner(System.in);
        double salary = 0;
        int creditScore = 0;
        boolean criminalRecord = false;
        int num ;
        float num2 = 0;
        int num3 =0;

        while(true){
              System.out.print("Enter your income: ");
        if (sc.hasNextDouble())  {      
                salary = sc.nextDouble();
               break;
        }else {
            System.out.println("Invalid input.Please enter a numeric value");
            sc.next();
        }
    }
       
        while(true){
        System.out.print("Enter Your credit score (0-500) :");
        if (sc.hasNextDouble())  {
                creditScore = sc.nextInt();
        if (creditScore >=0 || creditScore < 500) {
            break;
        } else{
             System.out.println("Credit Score must be between 0 and 500.");    
            }

        } else {
            System.out.println("Invalid input.Please enter numeric value between 0 and 500");
            sc.next();

        } 
    }
        
            while(true){  
                    System.out.print("Do you have any criminal record (True/False) :");
             if(sc.hasNextBoolean()) {
                     criminalRecord = sc.nextBoolean();
                    break;
             } else{
                System.out.println("Invalid input.please type true or false");
                sc.next();
             }

            }
            // Loan Eligibility Check
            boolean eligible = (creditScore >=300) && !criminalRecord;
            
            if (!eligible) {
                System.out.println(" You are not eligible for a loan.");
                System.out.println("Reason:");
                System.out.println("- Salary must be greater than 0.");
                System.out.println("- Credit score must be at least 300.");
                System.out.println("- Applicant must not have a criminal record.");
                sc.close();
                return;
            }
        
          while (true) {     
               System.out.print("Enter loan amount (principal in BDT): ");
          if (sc.hasNextInt()) {
                 num = sc.nextInt(); 
        if(num <= 2* salary){
            break;
        } else {
            System.out.println("Loan request denied .loan amount cannot exceed your twice salary");
        }
    }
}
       while(true) {
             System.out.print("Enter annual interest rate: ");
             if( sc.hasNextFloat()){
                     num2 = sc.nextFloat();
             break;
             } else{
                System.out.println("Invalid input.Please enter a numeric value");
                sc.next();
             }
             }
 
         while(true) {
               System.out.print("Enter loan period (in years): ");
             if(sc.hasNextInt()){
                     num3 = sc.nextInt();
                    break;
             } else {
                System.out.println("Invalid input .Please enter numeric value");
                sc.next();
             }
             }
 
        float r = ( num2 / 100f / 12f);  
        int n = num3* 12;          
 
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




 

