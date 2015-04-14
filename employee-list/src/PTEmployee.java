/**
 * <h1>PTEmployee</h1>
 * The PTEmployee class is the implementation of a part time Employee
 * <p>
 *
 * @author Pierre de Wet
 * @version 1.0
 * @since 2014-11-19
 */
public class PTEmployee extends FTEmployee
{

    /**
     * The hours worked by the part time Employee
     */
    protected double hours_worked;

    /**
     * The default constructor The pay is calculated and the Employee pay value
     * is updated at the time of instantiation
     *
     * @param name The employee name
     * @param works_number The Employee ID
     * @param hours_worked The number of hours worked by the employee
     */
    PTEmployee(String name, String works_number, double hours_worked)
    {
        super(name, works_number);
        this.hours_worked = hours_worked;
    }

    /**
     * @return Returns the hours that the Employee worked
     */
    public double getHoursWorked()
    {
        return hours_worked;
    }

    /**
     * @param hours_worked Sets the hours that the Employee worked
     */
    public void setHoursWorked(Double hours_worked)
    {
        this.hours_worked = hours_worked;
    }

    /**
     * The Part time staff member is paid a proportion of the full time salary
     * depending on the number of hours worked
     *
     * @return Calculate the salary as a function of the hours worked/the weekly
     * hours * the full time pay value
     */
    @Override
    public final double calculatePay()
    {
        return (hours_worked / WKLY_HRS * FT_PAY);
    }

    /**
     * Return the basic attributes of a full time employee
     *
     * @return Employee Name, Employee worksNo, Hours worked, Employee pay as a
     * String
     */
    @Override
    public String toString()
    {
        return "Name: " + name
                + ",WorksNo: " + works_no
                + ",Hours worked: " + hours_worked
                + ",Pay: " + pay + "\n";
    }
}
