import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * <h1>FileChooserDialog</h1>
 * The FileChooserDialog class allows the user to choose a file to import into
 * the StaffList
 * <p>
 *
 * @author Pierre de Wet
 * @version 1.0
 * @since 2014-11-19
 */
public class FileChooserDialog
{

    JFileChooser fileopen = null;
    FileFilter filter = null;

    /**
     * The default constructor Creates a new File chooser dialog, and sets the
     * directory to the current one
     */
    public FileChooserDialog()
    {
        fileopen = new JFileChooser();
        fileopen.setCurrentDirectory(new java.io.File("."));
        filter = new FileNameExtensionFilter("TXT File", "txt");
        fileopen.setFileFilter(filter);
    }

    /**
     * Attempts to open a file that the user selects
     *
     * @return Returns a File object representing the file that the user chose,
     * else null
     */
    public File browseFiles()
    {
        int ret = fileopen.showDialog(null, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION)
        {
            File file = fileopen.getSelectedFile();
            return file;
        } else
        {
            return null;
        }
    }
}
