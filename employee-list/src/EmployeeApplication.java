import java.io.*;

/**
 * <h1>EmployeeApplication</h1>
 * The EmployeeApplication class allows the user to build, maintain and print a
 * list of Employees
 * <p>
 *
 * @author Pierre de Wet
 * @version 1.0
 * @since 2014-11-19
 */
public class EmployeeApplication
{

    /**
     * The start program method
     *
     * @throws java.io.FileNotFoundException
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws FileNotFoundException, Exception
    {
        EmployeeApplication ac = new EmployeeApplication();
        StaffList staff = new StaffList();

        /**
         * Allows the user to select an input file
         */
        FileChooserDialog fc = new FileChooserDialog();
        File in = fc.browseFiles();
        staff.readInputFromFile(in);

        //Sort the Collection
        staff.sort();

        //Attempt to neatly print out the employee salary information
        ac.doPayRoll(staff);
    }

    /**
     * Attempts to print a list of formatted employee details
     *
     * @param staff The collection of Employees
     */
    public void doPayRoll(StaffList staff)
    {
        StaffPrinter staffprinter = new StaffPrinter(staff);
        staffprinter.printSalaryHeader();
        staffprinter.printSalaryDetails();
        staffprinter.printNumEmployees();
        staffprinter.printSalaryFooter();
    }
}
