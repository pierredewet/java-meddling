import java.text.*;
import java.util.*;

/**
 * <h1>StaffPrinter</h1>
 * The StaffPrinter class is used to produce neat printed output of the
 * StaffList
 * <p>
 *
 * @author Pierre de Wet
 * @version 1.0
 * @since 2014-11-19
 */
public class StaffPrinter
{

    /**
     * A list of headings for output
     */
    static final String[] head =
    {
        "NAME", "WORKS NO", "SALES TOT", "HOURS", "PAY TOT"
    };

    /**
     * Default column widths for neat printing
     */
    static final int WRKSNO_WIDTH = 11;
    static final int SALESTOT_WIDTH = 15;
    static final int HOURS_WIDTH = 8;
    static final int PAY_WIDTH = 15;

    StaffList staff;

    /**
     * Will hold the default column widths for neat output
     */
    LinkedHashMap<String, Integer> colWidths = new LinkedHashMap<String, Integer>();

    /**
     * Defines an output format for the monetary values
     */
    DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Conversion Constructor for the StaffPrinter Class
     *
     * @param staff A StaffList object
     */
    public StaffPrinter(StaffList staff)
    {
        this.staff = staff;

        colWidths.put(head[0], staff.getNameWidth());
        colWidths.put(head[1], WRKSNO_WIDTH);
        colWidths.put(head[2], SALESTOT_WIDTH);
        colWidths.put(head[3], HOURS_WIDTH);
        colWidths.put(head[4], PAY_WIDTH);
    }

    /**
     * Attempts to print Employee details from the collection
     */
    public void printSalaryDetails()
    {
        ArrayList<Employee> empList = staff.getStaffList();
        String placeHolder = "____";
        String empRecord = "";

        for (Employee emp : empList)
        {
            empRecord = String.format("%-" + colWidths.get("NAME") + "s", emp.getName());
            empRecord += String.format("%" + colWidths.get("WORKS NO") + "s", emp.getWorksNo());

            if (emp instanceof CommEmployee)
            {
                empRecord += String.format("%" + colWidths.get("SALES TOT") + "s", df.format(((CommEmployee) emp).getSalesTotal()));
            } else
            {
                empRecord += String.format("%" + colWidths.get("SALES TOT") + "s", placeHolder);
            }

            if (emp instanceof PTEmployee)
            {
                empRecord += String.format("%" + colWidths.get("HOURS") + "s", ((PTEmployee) emp).getHoursWorked());
            } else
            {
                empRecord += String.format("%" + colWidths.get("HOURS") + "s", placeHolder);
            }

            empRecord += String.format("%" + colWidths.get("PAY TOT") + "s", df.format(emp.getPay()));
            //empRecord += " --- " + emp.lastWorksNo;
            System.out.println(empRecord);
        }
    }

    /**
     * Attempts to print the heading of the Employee list
     */
    public void printSalaryHeader()
    {
        String underLine = "";
        int colNameWidth = 0;
        int spaceRemaining = 0;

        for (String key : colWidths.keySet())
        {
            colNameWidth = key.length();
            spaceRemaining = colWidths.get(key) - colNameWidth;

            if (key.equals("NAME"))
            {
                System.out.print(String.format("%-" + colWidths.get(key) + "s", key));
                underLine += repeatChar("=", colNameWidth);
                underLine += repeatChar(" ", spaceRemaining);
            } else
            {
                System.out.print(String.format("%" + colWidths.get(key) + "s", key));
                underLine += repeatChar(" ", spaceRemaining);
                underLine += repeatChar("=", colNameWidth);
            }
        }
        System.out.println();
        System.out.println(underLine);
    }

    /**
     * Attempts to print the footer from the Employee list as well as the total
     * salary value
     */
    public void printSalaryFooter()
    {
        String totSal = df.format(staff.getTotSalary());
        String totSalText = "Total Salary: ";
        String spacer = repeatChar(" ", totSalText.length());
        String overLine = repeatChar("_", totSal.length());
        String underLine = repeatChar("=", totSal.length());

        System.out.println();

        System.out.println(spacer + overLine);
        System.out.println(totSalText + totSal);
        System.out.println(spacer + underLine);
    }

    /**
     * Attempts to print the number of employees in the list
     */
    public void printNumEmployees()
    {
        String plural = (staff.getNumberOfEmployees() == 1) ? "Employee" : "Employees";
        String empTotal = "(" + staff.getNumberOfEmployees() + ") " + plural;
        System.out.println(empTotal);
    }

    /**
     * Repeats a character n times and fills a string with that character
     *
     * @param str The String to repeat
     * @param times The number of repetitions
     * @return A String value representing the repeated character
     */
    public String repeatChar(String str, int times)
    {
        return new String(new char[times]).replace("\0", str);
    }
}
