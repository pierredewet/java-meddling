/**
 * <h1>DrawingCanvas</h1>
 * The DrawingCanvas class models a virtual graphics canvas,
 * represented by a matrix of X/Y values
 * <p>
 *
 * @author 
 * @version 1.0
 * @since 2014-12-19
 */
public class DrawingCanvas
{
    private int width ;
    private int height ;
    private static int DEFAULT_HEIGHT = 200;
    private static int DEFAULT_WIDTH = 300;
    private static int DEFAULT_RGB = 255;
    Pixel[][] canvas = null ;

    /**
     * Default constructor
     * The canvas is instantiated with default values for size and colour
     * @throws java.lang.Exception
     */
    public DrawingCanvas() throws Exception
    {
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        Colour c = new Colour(DEFAULT_RGB);
        canvas = new Pixel[width][height] ;

        for ( int x = 0; x < width; x++ )
        {
            for ( int y = 0; y < height; y++ )
            {
                canvas[x][y] = new Pixel(x, y, c);
            }
        }
    }

    /**
     * Conversion constructor
     * @param width int value representing the width of the canvas
     * @param height int value representing the height of the canvas
     * @param c Colour object representing the colour of the canvas
     */
    public DrawingCanvas(int width, int height, Colour c)
    {
        this.width = width;
        this.height = height;
        canvas = new Pixel[width][height] ;
        for ( int x = 0; x < width; x++ )
        {
            for ( int y = 0; y < height; y++ )
            {
                canvas[x][y] = new Pixel(x, y, c);
            }
        }
    }

    /**
     * Gets the pixel at a point on the canvas
     * @param x int value representing the current X point
     * @param y int value representing the current Y point
     * @return Pixel object
     */
    public Pixel getPixel(int x, int y)
    {
        return canvas[x][y];
    }

    /**
     * Sets the Pixel value at a point on the canvas
     * @param x int value representing the current X point
     * @param y int value representing the current Y point
     * @param c Colour object representing the RGB value at that point
     */
    public void setPixel(int x, int y, Colour c)
    {
        canvas[x][y].setCol(c);
    }

    /**
     * Counts the number of Pixels on the canvas of a particular Colour
     * @param c Colour Object
     * @return int representing the number of Pixels of Colour c
     */
    public int count(Colour c)
    {
        int colourCount = 0;

        for ( int x = 0; x < width; x++ )
        {
            for ( int y = 0; y < height; y++ )
            {
                if (canvas[x][y].hasColour(c))
                {
                    colourCount++;
                }
            }
        }
        return colourCount;
    }

    /**
     * Draws a horizontal line on the canvas of a particular Colour and length
     * @param c Colour of the line
     * @param xs int Starting X point
     * @param ys int Starting Y point
     * @param len int length of the line
     */
    public void drawHLine(Colour c, int xs, int ys, int len)
    {
        if (ys < 0 || ys > height)
        {
            System.out.println("The Y value was incorrect: " + ys + " (max = " + height + ")");
        }
        else if ((xs + len) > width)
        {
            System.out.println("The X value was incorrect: " + xs + " (max = " + width + ")");
        }
        else
        {
            for (int col = xs; col < len; col++)
            {
                canvas[col][ys].setCol(c);
            }
        }
    }

    /**
     * Draws a vertical line on the canvas of a particular Colour and length
     * @param c Colour of the line
     * @param xs int Starting X point
     * @param ys int Starting Y point
     * @param len int length of the line
     */
    public void drawVLine( Colour c, int xs, int ys, int len )
    {
        if (xs < 0 || xs > width)
        {
            System.out.println("The X value was incorrect: " + xs + " (max = " + width + ")");
        }

        if ((ys + len) > height)
        {
            System.out.println("The Y value was incorrect: " + ys + " (max = " + height + ")");
        }
        for (int row = ys; row < len; row++)
        {
            canvas[xs][row].setCol(c);
        }
    }

    /**
     * Fills the canvas with a particular Colour
     * @param c Colour to fill the canvas with
     */
    public void fillCanvas(Colour c)
    {
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                canvas[x][y].setCol(c);
            }
        }
    }

    /**
     * Print out the canvas
     */
    public void paintCanvas()
    {
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                System.out.println("x: " + canvas[x][y].getxPos() + " y: " + canvas[x][y].getyPos() + " Colour: " + canvas[x][y].col.toString());
            }
        }
    }

    /**
     * Get the current canvas object
     * @return Pixel[][] 2D array
     */
    public Pixel[][] getCanvas()
    {
        return canvas;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
    }


}
