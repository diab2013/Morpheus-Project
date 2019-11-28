package morpheusproject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JComponent;

public class Picture extends JComponent{
    
    private static Image defaultPic;
    private String path = "C:\\Users\\Usager\\Desktop\\ImageRecognition Thread\\TrainingData\\printedImage.png";

    public Picture(String file) throws FileNotFoundException {
        read();
        this.setSize(1000, 1000);
    }

    private void read(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Usager\\Desktop\\ImageRecognition Thread\\imagePath.txt"));
            path = reader.readLine();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        defaultPic = Toolkit.getDefaultToolkit().getImage(path);
    }
    
    @Override
    public void paintComponent(Graphics grphcs) {
        super.paintComponents(grphcs);
        grphcs.drawImage(defaultPic, 0, 0, this);
    }
    
}
