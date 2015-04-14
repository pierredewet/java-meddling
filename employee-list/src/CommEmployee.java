/**
 * <h1>CommEmployee</h1>
 * The CommEmployee class is the implementation of a commissioned Employee
 * <p>
 *
 * @author Pierre de Wet
 * @version 1.0
 * @since 2014-11-19
 */
public class CommEmployee extends Employee
{

    /**
     * The Current commission percentage
     */
    static double COMMISIONPERCENT = 0.1;
    /**
     * The current base salary for commissioned employees
     */
    static double CO_PAY = 1000.00;

    /**
     * Holds the sales amount made by the employee
     */
    protected double sales_total;

    /**
     * The default constructor The pay is calculated and the Employee pay value
     * is updated at the time of instantiation
     *
     * @param name The employee name
     * @param works_number The Employee ID
     * @param sales_total The amount of sales made by the employee. Used to
     * calculate pay
     */
    CommEmployee(String name, String works_number, double sales_total)
    {
        super(name, works_number);
        this.sales_total = sales_total;
    }

    /**
     * @return Returns the sales amount that the employee made
     */
    public double getSalesTotal()
    {
        return sales_total;
    }

    /**
     * @param sales_total Sets the sales amount that the employee made
     */
    public void setSalesTotal(Double sales_total)
    {
        this.sales_total = sales_total;
    }

    /**
     * @param commperc Sets the Commission Percent
     */
    public static void setCommissionPercent(double commperc)
    {
        COMMISIONPERCENT = commperc;
    }

    /**
     * @param commsal Sets the Commission Base Salary
     */
    public static void setCommissionSalary(double commsal)
    {
        CO_PAY = commsal;
    }


    /**
     * The Commissioned Employee is paid a base rate and a percentage of total
     * sales that they made.
     *
     * @return calculate the pay as a function of a base salary + a percentage
     * of the sales made
     */
    @Override
    //public double calculatePay()
    public final double calculatePay()
    {
        return (CO_PAY + (sales_total * COMMISIONPERCENT));
    }

    /**
     * Return the basic attributes of a commissioned employee
     *
     * @return Employee Name, Employee worksNo, Sales total, Employee pay as a
     * String
     */
    @Override
    public String toString()
    {
        return "Name: " + name
                + ",WorksNo: " + works_no
                + ",Sales total: " + sales_total
                + ",Pay: " + pay + "\n";
    }
}
