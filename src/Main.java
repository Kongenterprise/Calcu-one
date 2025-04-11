    import java.util.Scanner;

    public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Principal Amount (no commas), e.g., 53000: ");
        double principalAmount = s.nextDouble();

        System.out.print("Annual Interest Rate (e.g., 7.625): ");
        double annualInterestRate = s.nextDouble();

        System.out.print("loanLength (e.g., 15): ");
        int years = s.nextInt();


        int MONTHS_IN_A_YEAR = 12;

        // Calculated values
        double monthlyInterestRate = annualInterestRate / 100 / MONTHS_IN_A_YEAR;
        int numberOfPayments = years * MONTHS_IN_A_YEAR;

        // Mortgage formula: M = P * [i(1+i)^n] / [(1+i)^n - 1]
        double expectedMonthlyPaymentAmount;
        if (monthlyInterestRate != 0) {
            expectedMonthlyPaymentAmount = principalAmount * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /(Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        } else {
            // Zero interest
            expectedMonthlyPaymentAmount = principalAmount / numberOfPayments;
        }

        // Total interest
        double totalPayment = expectedMonthlyPaymentAmount * numberOfPayments;
        double totalInterest = totalPayment - principalAmount;

        // Output
        System.out.printf("\n--- Loan Summary ---\n");
        System.out.printf("Monthly Payment: $%.2f\n", expectedMonthlyPaymentAmount);
        System.out.printf("Total Interest Paid: $%.2f\n", totalInterest);

    }
}
