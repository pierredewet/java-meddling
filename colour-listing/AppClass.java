/**
 * <h1>AppCLass</h1>
 * The App class contains the main program method and executes the Coursework task.
 * <p>
 *
 * @author 
 * @version 1.0
 * @since 2014-12-19
 */
import java.io.*;
import java.util.Scanner ;

public class AppClass
{
    public static void main(String[] args) throws FileNotFoundException, Exception
    {
        int width = 300;
        int height = 200;
        Colour black = new Colour(0);
        Colour white = new Colour(255);
        Colour yellow = new Colour(255, 255, 0);
        Colour red = new Colour(255, 0, 0);
        Colour green = new Colour(0, 255, 0);
        Colour blue = new Colour(0, 0, 255) ;
        Colour cyan = new Colour(0, 255, 255) ;

        //
        //Task 1
        //
        Colour A1 = new Colour(128);
        int A1startX = 10;
        int A1startY = A1startX;
        int A1lineLen = 100;

        Colour A2 = new Colour(250, 240, 80);
        int A2startX = 200;
        int A2startY = A1startX;
        int A2lineLen = 50;


        //Create a black canvas of width * height dimensions
        DrawingCanvas dc1 = new DrawingCanvas(width, height, black);

        // A1: Draw horizontal lines
        for (int y = 0; y < 30; y++)
        {
            dc1.drawHLine(A1, A1startX, A1startY + y, A1lineLen);
            A1 = A1.brighter();
        }

        //A2: Draw vertical lines
        for (int x = 0; x < 40; x++)
        {
            dc1.drawVLine(A2, A2startX + x, A2startY, A2lineLen);
            A2 = A2.darker();
        }

        //Task Output
        System.out.println("*******************************");
        System.out.println("");
        System.out.println("*******************************");
        System.out.println("Task 1: Output");
        System.out.println("*******************************");
        System.out.println("Total Black Pixels:\t" + dc1.count(black));
        System.out.println("Total White Pixels:\t" + dc1.count(white));
        System.out.println("*******************************");
        System.out.println("");

        //
        // Task 2
        //
        int x = 0;
        int y = 0;
        String line;
        Colour fileColour = null;

        int R = 0 ;
        int G = 0;
        int B = 0;

        // Run File Chooser window
        FileChooserDialog fc = new FileChooserDialog();
        File f = fc.browseFiles();

        try (BufferedReader buffRead = new BufferedReader(new FileReader(f)))
        {
            boolean empty = f.length() == 0;
            if (empty)
            {
                throw new EmptyFileException();
            }

            line = buffRead.readLine();
            x = Integer.parseInt(line);

            line = buffRead.readLine();
            y = Integer.parseInt(line);

            DrawingCanvas dc2 = new DrawingCanvas(x, y, black);

            for ( int h = 0; h < y; h++ )
            {
                for ( int w = 0; w < x; w++ )
                {
                    line = buffRead.readLine();
                    String[] fields = line.split("  ");
                    R   = Integer.parseInt(fields[0]);
                    G = Integer.parseInt(fields[1]);
                    B  = Integer.parseInt(fields[2]);
                    fileColour = new Colour(R, G, B);
                    dc2.setPixel(w, h, fileColour);
                }
            }
            System.out.println("*******************************");
            System.out.println("Task 2: Output");
            System.out.println("*******************************");
            System.out.println("Total Yellow Pixels:\t" + dc2.count(yellow));
            System.out.println("Total Red Pixels:\t" + dc2.count(red));
            System.out.println("Total Green Pixels:\t" + dc2.count(green));
            System.out.println("Total Blue Pixels:\t" + dc2.count(blue));
            System.out.println("Total Cyan Pixels:\t" + dc2.count(cyan));
            System.out.println("*******************************");
        }

        catch (FileNotFoundException fe)
        {
            System.err.format("ERROR: Input file doesn't exist in location - '%s'.\n", f);
            System.exit(0);
        }
        catch (IOException | RuntimeException iore)
        {
            System.err.format("ERROR: Invalid input attempted - '%s'.\n", f);
            System.exit(0);
        }
        catch (EmptyFileException ef)
        {
            System.err.format("ERROR: Attempt to read empty file - '%s'.\n", f);
            System.exit(0);
        }
    }

    static class EmptyFileException extends Exception
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
    static class NullFileException extends Exception
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

