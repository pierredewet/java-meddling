import java.io.*;
import java.util.*;

/**
 * <h1>StaffList</h1>
 * The StaffList class handles the creation and manipulation of a list of
 * Employees
 * <p>
 *
 * @author Pierre de Wet
 * @version 1.0
 * @since 2014-11-19
 */
public class StaffList
{

    /**
     * Used to hold the list of Employees
     */
    private final ArrayList<Employee> empList;

    /**
     * Holds the total salary for all the staff in the list
     */
    private Double totSalary = 0.0;
    /**
     * Is used to set the column width of the name field for proper spacing
     */
    private int nameWidth = 0;

    /**
     * The default constructor Instantiates the ArrayList of Employees
     */
    public StaffList()
    {
        empList = new ArrayList<Employee>();
    }

    /**
     * Instantiates the ArrayList of Employees
     *
     * @param emps An ArrayList of Employees
     */
    public StaffList(ArrayList<Employee> emps)
    {
        empList = emps;
        for (Employee emp : empList)
        {
            updateNameColWidth(emp.getName());
            addToTotSalary(emp.getPay());
        }
    }

    /**
     * Adds a new Employee to the list and updates the total salary
     *
     * @param e An Employee Object
     */
    public void add(Employee e)
    {
        double pay = e.calculatePay();
        e.setPay(pay);
        empList.add(e);
        addToTotSalary(e.getPay());
    }

    /**
     * Attempts to remove an Employee from the list and subtract that employees
     * salary from the current total
     *
     * @param idx The integer index of the Employee in the list
     * @return A boolean value representing if the attempt to remove the
     * Employee was successful
     */
    public boolean removeEmployee(int idx)
    {
        try
        {
            Employee e = getEmployee(idx);
            Double sal = e.getPay();
            subtractTotSalary(sal);
            empList.remove(idx);
            return true;
        } catch (IndexOutOfBoundsException e)
        {
            System.err.println("No valid staff member at this index [" + e.getMessage() + "]");
            return false;
        } catch (Exception e)
        {
            System.err.println("Caught General Exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Gets the number of characters of the longest name in the list
     *
     * @return An integer representing the number of characters of the longest
     * name in the list
     */
    public int getNameWidth()
    {
        return nameWidth;
    }

    /**
     * Attempts to extract a specific Employee from the list based on the index
     * value
     *
     * @param idx The integer index of the Employee in the list
     * @return An Employee object, or null, if the Employee does not exist
     */
    public Employee getEmployee(int idx)
    {
        try
        {
            return empList.get(idx);
        } catch (IndexOutOfBoundsException e)
        {
            System.err.println("Invalid staff index request [" + e.getMessage() + "]");
        } catch (Exception e)
        {
            System.err.println("Caught General Exception: " + e.getMessage());
        }
        /*
         As per stackoverflow question: 
         http://stackoverflow.com/questions/1626597/should-functions-return-null-or-an-empty-object
         */
        return null;
    }

    /**
     * Gets the number of Employees in the Collection
     *
     * @return the number of Employees in the Collection
     */
    public int getNumberOfEmployees()
    {
        return empList.size();
    }

    /**
     * Gets the list of full time employees from the collection
     *
     * @return a Collection of full time Employees
     */
    public ArrayList<Employee> getFullTimeEmployees()
    {
        ArrayList<Employee> ftlist = new ArrayList<Employee>();
        for (Employee emp : empList)
        {
            if (emp instanceof FTEmployee)
            {
                ftlist.add(emp);
            }
        }
        return ftlist;
    }

    /**
     * Gets the list of part time employees from the collection
     *
     * @return a Collection of part time Employees
     */
    public ArrayList<Employee> getPartTimeEmployees()
    {
        ArrayList<Employee> ptlist = new ArrayList<Employee>();
        for (Employee emp : empList)
        {
            if (emp instanceof PTEmployee)
            {
                ptlist.add(emp);
            }
        }
        return ptlist;
    }

    /**
     * Gets the list of commissioned employees from the collection
     *
     * @return a Collection of commissioned Employees
     */
    public ArrayList<Employee> getCOEmployees()
    {
        ArrayList<Employee> colist = new ArrayList<Employee>();
        for (Employee emp : empList)
        {
            if (emp instanceof CommEmployee)
            {
                colist.add(emp);
            }
        }
        return colist;
    }

    /**
     * Increments the total salary for the list.
     *
     * @param pay Double value representing the calculated Employee pay
     */
    public final void addToTotSalary(Double pay)
    {
        totSalary = totSalary + pay;
    }

    /**
     * Decrements the total salary for the list.
     *
     * @param pay Double value representing the calculated Employee pay
     */
    public void subtractTotSalary(Double pay)
    {
        totSalary -= pay;
    }

    /**
     * Gets the current total salary for all employees in the list.
     *
     * @return totSalary Total Salary for the list
     */
    public Double getTotSalary()
    {
        return totSalary;
    }

    /**
     * Sorts the current Employee list
     */
    public void sort()
    {
        Collections.sort(empList);
    }

    /**
     * Reads the input from a user-selected file
     *
     * @param f File value representing the selected file
     * @exception FileNotFoundException if f does not exist
     * @exception Exception if there is an issue reading f, or some other error
     */
    public void readInputFromFile(File f) throws FileNotFoundException, Exception
    {
        try (BufferedReader buffRead = new BufferedReader(new FileReader(f)))
        {
            String line;
            Employee e;
            boolean addEmp;
            //Check if file is empty 
            boolean empty = f.length() == 0;
            if (empty)
            {
                throw new EmptyFileException();
            }
            double pay = 0.0;
            //Loop through file and attempt to add Employees to list
            while ((line = buffRead.readLine()) != null)
            {
                addEmp = true;
                String[] fields = line.split(",");

                updateNameColWidth(fields[1]);

                switch (fields[0])
                {
                    case "FT":
                        e = new FTEmployee(fields[1], fields[2]);
                        break;
                    case "PT":
                        e = new PTEmployee(fields[1], fields[2], Double.parseDouble(fields[3]));
                        break;
                    case "CO":
                        e = new CommEmployee(fields[1], fields[2], Double.parseDouble(fields[3]));
                        break;
                    default:
                        System.out.println("Invalid staff record: " + line);
                        addEmp = false;
                        pay = 0.0;
                        e = null;
                }
                if (addEmp)
                {
                    pay = e.calculatePay();
                    e.setPay(pay);
                    empList.add(e);
                    addToTotSalary(e.getPay());
                }
            }
        } catch (FileNotFoundException fe)
        {
            System.err.format("ERROR: Input file doesn't exist in location - '%s'.\n", f);
            System.exit(0);
        } catch (IOException | RuntimeException iore)
        {
            System.err.format("ERROR: Invalid input attempted - '%s'.\n", f);
            System.exit(0);
        } catch (EmptyFileException ef)
        {
            System.err.format("ERROR: Attempt to read empty file - '%s'.\n", f);
            System.exit(0);
        }
    }

    /**
     * Generic print method for printing out the Employee list using the
     * standard toString() methods from the individual classes
     */
    public void printSalaryDetails()
    {
        for (Employee emp : empList)
        {
            System.out.println(emp.toString());
        }
    }

    /**
     * Will return the current list to the calling program
     *
     * @return a Collection of Employee objects
     */
    public ArrayList<Employee> getStaffList()
    {
        return empList;
    }

    /**
     * Updates the width of the Employee Name column based on width of longest
     * name in list.
     *
     * @param name a String representing an Employee name
     */
    public final void updateNameColWidth(String name)
    {
        if (name.length() > nameWidth)
        {
            nameWidth = name.length();
        }
    }

    /**
     * Thrown if input file is empty
     */
    class EmptyFileException extends Exception
    {

        /**
         * To prevent warning of undefined serialVersionUID
         */
        private static final long serialVersionUID = 1L;

        public EmptyFileException()
        {
        }

        public EmptyFileException(String message)
        {
            super(message);
        }
    }

    /**
     * Thrown if no input file selected
     */
    class NullFileException extends Exception
    {

        /**
         * To prevent warning of undefined serialVersionUID
         */
        private static final long serialVersionUID = 1L;

        public NullFileException()
        {
        }

        public NullFileException(String message)
        {
            super(message);
        }
    }
}
