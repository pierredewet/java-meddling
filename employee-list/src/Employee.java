/**
 * <h1>Employee</h1>
 * The Employee class is an abstract class used to template concrete Employee
 * types
 * <p>
 *
 * @author Pierre de Wet
 * @version 1.0
 * @since 2014-11-19
 */
public abstract class Employee implements Comparable<Employee>
{
    /**
     * The name of the Employee
     */
    protected String name;
    /* The Employee works_no (ID) */
    protected String works_no;
    /**
     * The Employee's pay
     */
    protected double pay;

    //static int lastWorksNo = 999;

    /**
     * Conversion constructor
     *
     * @param name Employee Name
     * @param works_no Employee Works No
     */
    public Employee(String name, String works_no)
    {
        this.name = name;
        this.works_no = works_no;
        //lastWorksNo = assignStaffID();
    }

    /**
     * Returns the Employee name
     *
     * @return Employee name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the Employee name
     *
     * @param name Employee Name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns the Employee Works No
     *
     * @return Employee Works No
     */
    public String getWorksNo()
    {
        return works_no;
    }

    /**
     * Returns the Employee pay
     *
     * @return Employee pay
     */
    public double getPay()
    {
        return pay;
    }

    /**
     * Sets the Employee name
     *
     * @param pay Employee pay value
     */
    public void setPay(double pay)
    {
        this.pay = pay;
    }

    // static int assignStaffID()
    // {
    //     //lastWorksNo++;
    //     //return lastWorksNo;
    // }


    @Override
    public String toString()
    {
        return "Name: " + name
                + ",WorksNo: " + works_no
                + ",Pay: " + pay + "\n";
    }

    /**
     * Override the standard comparable method in order to allow sorting by
     * Employee names
     *
     * @param e An Employee Object
     */
    @Override
    public int compareTo(Employee e)
    {
        return (getName()).compareTo(e.getName());
    }

    /**
     * The pay calculation will be overridden in subclasses depending on the
     * type of Employee
     */
    abstract double calculatePay();
}
