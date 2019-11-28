package morpheusproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ChangePicture extends JFrame{
    
    private String newFilePath;

    public ChangePicture() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
        chooser.setFileFilter(filter);
        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
            newFilePath = chooser.getSelectedFile().getAbsolutePath();
            saveFilePath();
        }        
    }
    
    private void saveFilePath(){
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Usager\\Desktop\\ImageRecognition Thread\\imagePath.txt")));
            writer.println(newFilePath);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
        }
    }

    public String getNewFilePath() {
        return newFilePath;
    }

}
