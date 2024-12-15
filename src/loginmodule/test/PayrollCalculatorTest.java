package loginmodule.test;

import loginmodule.PayrollCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayrollCalculatorTest {
    private PayrollCalculator payrollCalculator;

    @Before
    public void setUp() throws Exception {
        payrollCalculator = new PayrollCalculator();
    }

    @Test
    public void testGetTotalSalary() {
        double hourlyRate = 20.0;
        double hours = 40.0;
        double overtime = 10.0;

        double expectedRegularPay = hourlyRate * hours;
        double expectedOvertimePay = (hourlyRate * 1.5) * overtime;
        double expectedTotalSalary = expectedRegularPay + expectedOvertimePay;

        double totalSalary = payrollCalculator.getTotalSalary(hourlyRate, hours, overtime);

        assertEquals(expectedTotalSalary, totalSalary, 0.001);
    }

    @Test
    public void testGetRegularPay() {
        double hourlyRate = 20.0;
        double hours = 40.0;
        double overtime = 10.0;

        payrollCalculator.getTotalSalary(hourlyRate, hours, overtime);

        double expectedRegularPay = hourlyRate * hours;
        assertEquals(expectedRegularPay, payrollCalculator.getRegularPay(), 0.001);
    }

    @Test
    public void testGetOverTimePay() {
        double hourlyRate = 20.0;
        double hours = 40.0;
        double overtime = 10.0;

        payrollCalculator.getTotalSalary(hourlyRate, hours, overtime);

        double expectedOvertimePay = (hourlyRate * 1.5) * overtime;
        assertEquals(expectedOvertimePay, payrollCalculator.getOverTimePay(), 0.001);
    }
}
