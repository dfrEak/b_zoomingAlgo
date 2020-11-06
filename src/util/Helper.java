package util;

import domain.ImageContainer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;

/**
 * Helper Class.
 * <P>This is a class that contains many helper procedure.
 * <P>Last update 01/04/2013 by d_frEak.
 * 
 * @author d_frEak
 * @version 1.0
 * @since 09/03/2013
 */
public class Helper {
    
    private static int MAX_RGB = 255;
    /**
     * This is procedure will convert image to bufferedimage.
     * <P>Last update 01/04/2013 by d_frEak.
     * 
     * @param pInput the image source.
     * @return image in BufferedImage.
     * @since 09/03/2013
     */
    public static BufferedImage imageToBufferedImage(Image pInput) {
        BufferedImage temp = new BufferedImage(pInput.getWidth(null), pInput.getHeight(null), 
                BufferedImage.TYPE_INT_RGB);
        Graphics graph = temp.getGraphics();
        graph.drawImage(pInput, 0, 0, null);
        graph.dispose();
        return temp;
    }
    
    /**
     * This is procedure will convert icon to bufferedimage.
     * <P>Last update 01/04/2013 by d_frEak.
     * 
     * @param pInput the icon source.
     * @return image in BufferedImage.
     * @since 09/03/2013
     */
    public static BufferedImage iconToBufferedImage(Icon pInput) {
        BufferedImage temp = new BufferedImage(pInput.getIconWidth(), pInput.getIconHeight(), 
                BufferedImage.TYPE_INT_RGB);
        Graphics graph = temp.createGraphics();
        // paint the icon to BufferedImage
        pInput.paintIcon(null, graph, 0,0);
        graph.setColor(Color.WHITE);
        graph.dispose();
        return temp;
    }
    
    /**
     * This is procedure will return the color in poin (pX,pY) of the image.
     * <P>Last update 01/04/2013 by d_frEak.
     * 
     * @param image the image source.
     * @param pX x coordinate of the pixel.
     * @param pY y coordinate of the pixel.
     * @return image result.
     * @since 09/03/2013
     */
    public static Color getColor(BufferedImage image, int pX, int pY) {
        int colorInt = image.getRGB(pX, pY);
        return new Color(colorInt);
    }
    
    /**
     * This is procedure will try to parse string to integer.
     * <P>Last update 01/04/2013 by d_frEak.
     * 
     * @param value the string integer.
     * @return true if it can be parsed.
     * @since 09/03/2013
     */
    public static boolean tryParseInt(String value)  
    {  
        try  
        {  
            Integer.parseInt(value);  
            return true;  
        } catch(NumberFormatException nfe)  
        {  
            return false;  
        }  
    }
    
    /**
     * This is procedure will try to parse string to double.
     * <P>Last update 01/04/2013 by d_frEak.
     * 
     * @param value the string double.
     * @return true if it can be parsed.
     * @since 09/03/2013
     */
    public static boolean tryParseDouble(String value)  
    {  
        try  
        {  
            Double.parseDouble(value);  
            return true;  
        } catch(NumberFormatException nfe)  
        {  
            return false;  
        }  
    }
    
    /**
     * This is procedure will check the mse, psnr, and cc from two image.
     * <P>Last update 01/04/2013 by d_frEak.
     * 
     * @param sourceimage the image source.
     * @param compareimage the image compare.
     * @return the ImageContainer that contain the mse, psnr, and cc.
     * @since 09/03/2013
     */
    public static ImageContainer imageCompare(BufferedImage sourceimage, BufferedImage compareimage)  
    {  
        ImageContainer container = new ImageContainer();
        double mse, msered = 0, msegreen = 0, mseblue = 0;
        double psnr, psnrred, psnrgreen, psnrblue;
        double ab = 0, abred = 0, abgreen = 0, abblue = 0;
        double a2 = 0, a2red = 0, a2green = 0, a2blue = 0;
        double b2 = 0, b2red = 0, b2green = 0, b2blue = 0;
        double a = 0, ared = 0, agreen = 0, ablue = 0;
        double b = 0, bred = 0, bgreen = 0, bblue = 0;
        double crosscorrelation, crosscorrelationred, crosscorrelationgreen, crosscorrelationblue;
        
        Color color,comparecolor;
        
        for(int i=0;i<sourceimage.getWidth();i++)
        {
            for(int j=0;j<sourceimage.getHeight();j++)
            {
                if(i<compareimage.getWidth() && j<compareimage.getHeight())
                {
                    color = getColor(sourceimage, i, j);
                    comparecolor = getColor(compareimage, i, j);
                    
                    msered+=Math.pow(color.getRed()-comparecolor.getRed(),2);
                    msegreen+=Math.pow(color.getGreen()-comparecolor.getGreen(),2);
                    mseblue+=Math.pow(color.getBlue()-comparecolor.getBlue(),2);
                    
                    abred+=color.getRed()*comparecolor.getRed();
                    abgreen+=color.getGreen()*comparecolor.getGreen();
                    abblue+=color.getBlue()*comparecolor.getBlue();
                    ab+=(color.getRed()+color.getGreen()+color.getBlue())
                            *(comparecolor.getRed()+comparecolor.getGreen()+comparecolor.getBlue());
                    
                    a2red+=Math.pow(color.getRed(),2);
                    a2green+=Math.pow(color.getGreen(),2);
                    a2blue+=Math.pow(color.getBlue(),2);
                    a2+=Math.pow(color.getRed()+color.getGreen()+color.getBlue(),2);
                    
                    b2red+=Math.pow(comparecolor.getRed(),2);
                    b2green+=Math.pow(comparecolor.getGreen(),2);
                    b2blue+=Math.pow(comparecolor.getBlue(),2);
                    b2+=Math.pow(comparecolor.getRed()+comparecolor.getGreen()+comparecolor.getBlue(),2);
                    
                    ared+=color.getRed();
                    agreen+=color.getGreen();
                    ablue+=color.getBlue();
                    a+=color.getRed()+color.getGreen()+color.getBlue();
                    
                    bred+=comparecolor.getRed();
                    bgreen+=comparecolor.getGreen();
                    bblue+=comparecolor.getBlue();
                    b+=comparecolor.getRed()+comparecolor.getGreen()+comparecolor.getBlue();
                }
            }
        }
        
        mse=msered+msegreen+mseblue;
        
        int size=sourceimage.getWidth()*sourceimage.getHeight();
        
        // finishing calculate mse
        msered=msered/size;
        msegreen=msegreen/size;
        mseblue=mseblue/size;
        mse=mse/(size*3);
        
        // calculate psnr
        psnrred=(10*Math.log10((Math.pow(MAX_RGB,2)/msered)));
        psnrgreen=(10*Math.log10((Math.pow(MAX_RGB,2)/msegreen)));
        psnrblue=(10*Math.log10((Math.pow(MAX_RGB,2)/mseblue)));
        psnr=(10*Math.log10((Math.pow(MAX_RGB,2)/mse)));
        
        // calculate cross correlation
        crosscorrelationred=Math.abs((abred-ared*bred/size)
                /Math.sqrt((a2red-Math.pow(ared, 2)/size)*
                (b2red-Math.pow(bred, 2)/size)));
        crosscorrelationgreen=Math.abs((abgreen-agreen*bgreen/size)
                /Math.sqrt((a2green-Math.pow(agreen, 2)/size)*
                (b2green-Math.pow(bgreen, 2)/size)));
        crosscorrelationblue=Math.abs((abblue-ablue*bblue/size)
                /Math.sqrt((a2blue-Math.pow(ablue, 2)/size)*
                (b2blue-Math.pow(bblue, 2)/size)));
        crosscorrelation=Math.abs((ab-a*b/size)
                /Math.sqrt((a2-Math.pow(a, 2)/size)*
                (b2-Math.pow(b, 2)/size)));
        
        // insert the container
        container.setImage(sourceimage);
        container.setMse(mse);
        container.setMsered(msered);
        container.setMsegreen(msegreen);
        container.setMseblue(mseblue);
        container.setPsnr(psnr);
        container.setPsnrred(psnrred);
        container.setPsnrgreen(psnrgreen);
        container.setPsnrblue(psnrblue);
        container.setCrosscorrelation(crosscorrelation);
        container.setCrosscorrelationred(crosscorrelationred);
        container.setCrosscorrelationgreen(crosscorrelationgreen);
        container.setCrosscorrelationblue(crosscorrelationblue);
        return container;
    }
    
    
    /**
     * This is procedure will check the mse, psnr, and cc from two image.
     * <P>Last update 01/04/2013 by d_frEak.
     * 
     * @param sourceimage the image source.
     * @param compareimage the image compare.
     * @return the string of mse, psnr, and cc.
     * @since 09/03/2013
     */
    public static String stringImageCompare(BufferedImage sourceimage, BufferedImage compareimage)  
    {  
        ImageContainer container=imageCompare(sourceimage, compareimage);
        String retval="";
        retval+="All: \nmse="+container.getMse()+" \npsnr="+container.getPsnr()+" \ncc="+container.getCrosscorrelation();
        retval+="\n\nRed: \nmse="+container.getMsered()+" \npsnr="+container.getPsnrred()+" \ncc="+container.getCrosscorrelationred();
        retval+="\n\nGreen: \nmse="+container.getMsegreen()+" \npsnr="+container.getPsnrgreen()+" \ncc="+container.getCrosscorrelationgreen();
        retval+="\n\nBlue: \nmse="+container.getMseblue()+" \npsnr="+container.getPsnrblue()+" \ncc="+container.getCrosscorrelationblue();
        System.out.println("All: mse="+container.getMse()+", psnr="+container.getPsnr()+", cc="+container.getCrosscorrelation());
        System.out.println("Red: mse="+container.getMsered()+", psnr="+container.getPsnrred()+", cc="+container.getCrosscorrelationred());
        System.out.println("Green: mse="+container.getMsegreen()+", psnr="+container.getPsnrgreen()+", cc="+container.getCrosscorrelationgreen());
        System.out.println("Blue: mse="+container.getMseblue()+", psnr="+container.getPsnrblue()+", cc="+container.getCrosscorrelationblue());
        return retval;
    }
}
