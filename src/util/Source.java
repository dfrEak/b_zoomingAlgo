package util;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Source Class.
 * <P>This is a singleton class that contains the source image.
 * <P>Last update 01/04/2013 by d_frEak.
 * 
 * @author d_frEak
 * @version 1.0
 * @since 09/03/2013
 */
public class Source {
    
    /**
    * The singleton variable.
    */
    static private Source source=null;
    
    /**
    * The singleton procedure.
    */
    public static Source Singleton()
    {
        if(source == null)
        {
            source = new Source();
        }
        return source;
    }
    
    /**
    * The image source.
    */
    private BufferedImage image=null;

    /**
    * Getter for image.
    */
    public BufferedImage getImage() {
        return image;
    }

    /**
    * Setter for image.
    */
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    /**
    * Getter for Image height.
    */
    public int getHeight()
    {
        return image.getHeight();
    }
    
    /**
    * Getter for Image width.
    */
    public int getWidth()
    {
        return image.getWidth();
    }
    
    /**
    * Getter for Image color.
    * @param pX x coordinate of the pixel.
    * @param pY y coordinate of the pixel.
    * @return the color in poin (pX,pY).
    */
    public Color getColor(int pX, int pY) {
        int colorInt = image.getRGB(pX, pY);
        return new Color(colorInt);
    }
}
