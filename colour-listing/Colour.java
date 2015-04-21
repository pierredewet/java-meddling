/**
 * <h1>Colour</h1>
 * The Colour class represents an RGB triple
 * <p>
 *
 * @author 
 * @version 1.0
 * @since 2014-12-19
 */
public class Colour
{
    private static final int RGB_MAX = 255;
    private static final int RGB_MIN = 0;
    private static double BRIGHT_PERC = 1.42;
    private static double DARKEN_PERC = 0.3;
    private static int RGB_ERROR = 3;
    private static final String ERR_MSG = "Colour parameter outside of expected range: ";
    private int r;
    private int g;
    private int b;

    /**
     * Default constructor. The RGB values are set to RGB_MAX
     */
    public Colour()
    {
        this.r = RGB_MAX;
        this.g = RGB_MAX;
        this.b = RGB_MAX;
    }

    /**
     * Conversion constructor
     * Integers outside of the valid range (0-255) will be set to the
     * RGB_MIN value if &lt; 0, or the RGB_MAX value if &gt; 0
     * @param col int Representing a single colour
     * @throws java.lang.Exception
     */
    public Colour(int col) throws IllegalArgumentException
    {
        if (col < RGB_MIN || col > RGB_MAX)
        {
            throw new IllegalArgumentException(ERR_MSG + col);
        }
        this.r = this.g = this.b = col;
    }

    /**
     * Conversion constructor
     * Represents a colour which can be composed of different RGB values
     * @param r int representing the Red part of the triple
     * @param g int representing the Green part of the triple
     * @param b int representing the Blue part of the triple
     * @throws java.lang.Exception
     *
     */
    public Colour(int r, int g, int b) throws IllegalArgumentException, Exception
    {
        if (r < RGB_MIN || r > RGB_MAX)
        {
            throw new IllegalArgumentException("Red " + ERR_MSG + r);
        }

        if (g < RGB_MIN || g > RGB_MAX)
        {
            throw new IllegalArgumentException("Green " + ERR_MSG + g);
        }

        if (b < RGB_MIN || b > RGB_MAX)
        {
            throw new IllegalArgumentException("Blue " + ERR_MSG + b);
        }
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Make a brighter shade of the current colour
     * Any value &lt; 0 will be replaced by an error value RGB_ERROR
     * @return Colour object representing a brighter version of the current Colour
     * @throws java.lang.Exception
     */
    public Colour brighter() throws Exception
    {
        Colour newCol = new Colour();

        //Set R
        if ((this.r == RGB_MIN))
        {
            newCol.setR(RGB_ERROR);
        }
        else if ((this.r * BRIGHT_PERC) > RGB_MAX)
        {
            newCol.setR(RGB_MAX);
        }
        else
        {
            newCol.setR((int) (this.r * BRIGHT_PERC));
        }

        //Set G
        if ((this.g == RGB_MIN))
        {
            newCol.setG(RGB_ERROR);
        }
        else if ((this.g * BRIGHT_PERC) > RGB_MAX)
        {
            newCol.setG(RGB_MAX);
        }
        else
        {
            newCol.setG((int) (this.g * BRIGHT_PERC));
        }

        //Set B
        if ((this.b == RGB_MIN))
        {
            newCol.setB(RGB_ERROR);
        }
        else if ((this.b * BRIGHT_PERC) > RGB_MAX)
        {
            newCol.setB(RGB_MAX);
        }
        else
        {
            newCol.setB((int) (this.b * BRIGHT_PERC));
        }

        return newCol;

    }

    /**
     * Make a darker shade of the current colour
     * If the Colour is an error, return the original colour
     * @return Colour object representing a darker version of the current Colour
     * @throws java.lang.Exception
     */
    public Colour darker() throws Exception
    {
        Colour newCol = new Colour();

        //Darken R
        if ((this.r * (1 - DARKEN_PERC)) < RGB_MIN)
        {
            newCol.setR(RGB_MIN);
        }
        else
        {
            newCol.setR((int) (this.r * (1 - DARKEN_PERC)));
        }

        //Darken G
        if ((this.g * (1 - DARKEN_PERC)) < RGB_MIN)
        {
            newCol.setG(RGB_MIN);
        }
        else
        {
            newCol.setG((int) (this.g * (1 - DARKEN_PERC)));
        }

        //Darken B
        if ((this.b * (1 - DARKEN_PERC)) < RGB_MIN)
        {
            newCol.setB(RGB_MIN);
        }
        else
        {
            newCol.setB((int) (this.b * (1 - DARKEN_PERC)));
        }

        return newCol;
    }

    /**
     * Gets the Red value of the triple
     * @return int value representing the Red part
     */
    public int getR()
    {
        return r;
    }

    /**
     * Gets the Green value of the triple
     * @return int value representing the Green part
     */
    public int getG()
    {
        return g;
    }

    /**
     * Gets the Blue value of the triple
     * @return int value representing the Blue part
     */
    public int getB()
    {
        return b;
    }

    /**
     * Set the Red part of the Colour
     * Integers outside of the valid range (0-255) will be set to the
     * RGB_MIN value if &lt; 0, or the RGB_MAX value if &gt; 0
     * @param r int representing the Red part
     * @throws java.lang.Exception
     */
    public void setR(int r) throws Exception
    {
        this.r = (trueColour(r) == -1) ? this.r : r;
    }

    /**
     * Set the Green part of the Colour
     * Integers outside of the valid range (0-255) will be set to the
     * RGB_MIN value if &lt; 0, or the RGB_MAX value if &gt; 0
     * @param g int representing the Green part
     * @throws java.lang.Exception
     */
    public void setG(int g) throws Exception
    {
        this.g = (trueColour(g) == -1) ? this.g : g;
    }

    /**
     * Set the Blue part of the Colour
     * Integers outside of the valid range (0-255) will be set to the
     * RGB_MIN value if &lt; 0, or the RGB_MAX value if &gt; 0
     * @param b int representing the Blue part
     * @throws java.lang.Exception
     */
    public void setB(int b) throws Exception
    {
        this.b = (trueColour(b) == -1) ? this.b : b;
    }

    /**
     * Gets the current default brighten percentage
     * @return static Double representing the percentage by
     * which a colour is brightened
     */
    public static double getBRIGHT_PERC()
    {
        return BRIGHT_PERC;
    }

    /**
     * Sets the brighten percentage to a new value
     * @param aBRIGHT_PERC a Double representing the new brighten percentage
     */
    public static void setBRIGHT_PERC(double aBRIGHT_PERC)
    {
        Colour.BRIGHT_PERC = aBRIGHT_PERC;
    }

    /**
     * Gets the current default darken percentage
     * @return static Double representing the percentage by
     * which a colour is darkened
     */
    public static double getDARKEN_PERC()
    {
        return DARKEN_PERC;
    }

    /**
     * Sets the darken percentage to a new value
     * @param aDARKEN_PERC a Double representing the new brighten percentage
     */
    public static void setDARKEN_PERC(double aDARKEN_PERC)
    {
        Colour.DARKEN_PERC = aDARKEN_PERC;
    }

    /**
     * Gets the current error value
     * @return static int representing the current error replacement value
     */
    public static int getRGB_ERROR()
    {
        return RGB_ERROR;
    }

    /**
     * Sets the default error value to a new value for the class
     * @param RGB_ERROR an int value representing the new error value
     */
    public static void setRGB_ERROR(int RGB_ERROR)
    {
        Colour.RGB_ERROR = RGB_ERROR;
    }

    /**
     * Checks that the integer value passed is in the correct range
     * @param col int representing an int to be checked if in range
     * @return int a valid part of an RGB triple in the range 0 - 255
     * @throws java.lang.Exception
     */
    public final int trueColour(int col) throws Exception
    {
        try
        {
            if (col > RGB_MAX || col < RGB_MIN)
            {
                throw new NotValidColourException();
            }
            else
            {
                return col;
            }
        }
        catch (NotValidColourException nvce)
        {
            System.err.format(ERR_MSG + "%s\n", col);
        }
        return -1;
    }

    /**
     * Gets a String value of the Colour
     * @return String representing the text value of the Colour
     */
    @Override
    public String toString()
    {
        return "Colour [" + "R=" + r + ", G=" + g + ", B=" + b + "]";
    }

    /**
     * Checks if one Colour equals another
     * @return boolean on matching Colour check
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Colour other = (Colour) obj;
        return (this.r == other.r && this.g == other.g && this.b == other.b);
    }

    /**
     * Thrown if RGB triple is outside of valid range
     */
    class NotValidColourException extends Exception
    {
        /**
         * To prevent warning of undefined serialVersionUID
         */
        private static final long serialVersionUID = 1L;

        public NotValidColourException()
        {
        }

        public NotValidColourException(String message)
        {
            super(message);
        }
    }
}