/**
 * <h1>Pixel</h1>
 * The Pixel class represents the depiction of a pixel at a certain location, of a certain colour.
 * <p>
 *
 * @author Group B: Maria, Peter, Pierre
 * @version 1.0
 * @since 2014-12-19
 */
public class Pixel
{
    Colour col;
    int xPos;
    int yPos;

    /**
     * The Default constructor. Sets the Pixel to x = 0, y = 0, Colour = Black
     * @throws java.lang.Exception
     */
    public Pixel() throws Exception
    {
        xPos = 0;
        yPos = 0;
        col = new Colour(0);
    }

    /**
     * Conversion Constructor
     * @param x int representing the horizontal position of the pixel
     * @param y int representing the vertical position of the pixel
     * @param c Colour representing an RGB triple
     */
    public Pixel(int x, int y, Colour c)
    {
        this.xPos = x;
        this.yPos = y;
        this.col = c;
    }

    /**
     * Gets the X position
     * @return int xPos the x position of the pixel
     */
    public int getxPos()
    {
        return xPos;
    }

    /**
     * Sets the X position
     * @param xPos int set the x position of the pixel
     */
    public void setxPos(int xPos)
    {
        this.xPos = xPos;
    }

    /**
     * Gets the Y position
     * @return int yPos the y position of the pixel
     */
    public int getyPos()
    {
        return yPos;
    }

    /**
     * Sets the Y position
     * @param yPos int set the y position of the pixel
     */
    public void setyPos(int yPos)
    {
        this.yPos = yPos;
    }

    /**
     * Gets the current Colour value
     * @return Colour instance
     */
    public Colour getCol()
    {
        return col;
    }

    /**
     * Sets the Colour value for the pixel
     * @param col set the Colour value for the pixel
     */
    public void setCol(Colour col)
    {

        this.col = col;
    }

    /**
     * Checks if the colour of the current pixel matches a given value
     * @param c Colour value
     * @return boolean representing a colour match.
     */
    public boolean hasColour(Colour c)
    {
        return this.col.getR() == c.getR()
               && this.col.getG() == c.getG()
               && this.col.getB() == c.getB();
    }

    /**
     * Checks if the current x and y value are the same
     * @return boolean if the x and y are at the same position
     */
    public boolean isSameLocation()
    {
        return (this.xPos == this.yPos);
    }
}
