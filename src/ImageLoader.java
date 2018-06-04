import javax.swing.*;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class ImageLoader {
    public static BufferedImage getImg(final String file){
        return (BufferedImage)(Toolkit.getDefaultToolkit().getImage(file));
    }

    public static BufferedImage getImg2(final String file){
        return (BufferedImage)((new ImageIcon(file)).getImage());
    }
}