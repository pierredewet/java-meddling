/**
 * <h1>FTEmployee</h1>
 * The FTEmployee class is the implementation of a full time Employee
 * <p>
 *
 * @author Pierre de Wet
 * @version 1.0
 * @since 2014-11-19
 */
public class FTEmployee extends Employee
{

    /**
     * The current Full time pay for staff
     */
    static double FT_PAY = 2000.00;
    /**
     * The number of hours that full time staff work
     */
    static double WKLY_HRS = 40.0;

    /**
     * The default constructor The pay is calculated and the Employee pay value
     * is updated at the time of instantiation
     *
     * @param name The employee name
     * @param worksNo The Employee ID
     */
    FTEmployee(String name, String worksNo)
    {
        super(name, worksNo);
    }

    /**
     * The Full Time global weekly hours total
     *
     * @return double WKLY_HRS
     */
    protected double getWklyHours()
    {
        return WKLY_HRS;
    }

    /**
     * The default Full Time pay level
     *
     * @return double FT_Pay
     */
    protected double getWklyPay()
    {
        return FT_PAY;
    }

    static void setBaseFTPay(double ft_pay)
    {
        FT_PAY = ft_pay;
    }


    /**
     * 
     */
    static void setWklyHours(double wkly_hours)
    {
        WKLY_HRS = wkly_hours;
    }

    /**
     * The Full time staff member is paid the default amount
     *
     * @return get the static FT_PAY attribute from the Employee superclass
     */
    @Override
    public double calculatePay()
    {
        return FT_PAY;
    }

    /**
     * Return the basic attributes of a full time employee
     *
     * @return Employee Name, Employee worksNo, Employee pay as a String
     */
    @Override
    public String toString()
    {
        return "Name: " + name
                + ",WorksNo: " + works_no
                + ",Pay: " + pay + "\n";
    }
}
