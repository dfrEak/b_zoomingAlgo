package zooming;

import domain.ImageContainer;
import java.awt.Color;
import java.awt.image.BufferedImage;
import util.Helper;

/**
 * ZoomingAlgorithm Class.
 * <P>This is a class that contains some zooming algorithm.
 * <P>Last update 10/04/2013 by d_frEak.
 * 
 * @author d_frEak
 * @version 1.0
 * @since 09/03/2013
 */
public class ZoomingAlgorithm {
    
    /* ================================================================================================================= *
     * TAG: Nearest Neighbor Algorithm ================================================================================= *
     * ================================================================================================================= */
    
    /**
     * This is procedure will use the nearestneighbor algorithm.
     * <P>Last update 01/04/2013 by d_frEak.
     * 
     * @param sourceimage the image source.
     * @param ratio the ratio of zooming (0-1 to zoom out and >1 to zoom in).
     * @return image result.
     * @since 09/03/2013
     */
    static public BufferedImage NearestNeighbor(BufferedImage sourceimage, double ratio)
    {
        // check whether sourceimage is null
        if(sourceimage==null)
        {
            return null;
        }
        // check whether ratio is negative
        if(ratio<0)
        {
            return null;
        }
        
        int width = (int) (sourceimage.getWidth()*ratio);
        int height = (int) (sourceimage.getHeight()*ratio);
        System.out.println("new zooming : "+width+" x "+height);
        BufferedImage imageresult = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Color color;
        int ipixel,jpixel;
        
        for(int i=0;i<width;i++)
        {
            for(int j=0;j<height;j++)
            {
                ipixel = (int) (i/ratio);
                jpixel = (int) (j/ratio);
                
                color = Helper.getColor(sourceimage, ipixel, jpixel);
                imageresult.setRGB(i, j, color.getRGB());
            }
        }
        
        return imageresult;
    }
    
    /**
     * This is procedure will use the nearestneighbor algorithm.
     * <P>Last update 01/04/2013 by d_frEak.
     * 
     * @param sourceimage the image source.
     * @param ratio the ratio of zooming (0-1 to zoom out and >1 to zoom in).
     * @param compareimage the image that will be compared to image result.
     * @return image result.
     * @since 20/03/2013
     */
    static public ImageContainer NearestNeighbor(BufferedImage sourceimage, double ratio, BufferedImage compareimage)
    {
        BufferedImage result=NearestNeighbor(sourceimage, ratio);
        if(result==null)
        {
            return null;
        }
        return Helper.imageCompare(result, compareimage);
    }
    
    /* ================================================================================================================= *
     * TAG: Bilinear Algorithm ========================================================================================= *
     * ================================================================================================================= */ 
    
    /**
     * This is procedure will use the bilinear algorithm.
     * <P>Last update 01/04/2013 by d_frEak.
     * 
     * @param sourceimage the image source.
     * @param ratio the ratio of zooming (0-1 to zoom out and >1 to zoom in).
     * @return image result.
     * @since 09/03/2013
     */
    static public BufferedImage Bilinear(BufferedImage sourceimage, double ratio)
    {
        // check whether sourceimage is null
        if(sourceimage==null)
        {
            return null;
        }
        // check whether ratio is negative
        if(ratio<0)
        {
            return null;
        }
        
        int width = (int) (sourceimage.getWidth()*ratio);
        int height = (int) (sourceimage.getHeight()*ratio);
        Color color;
        
        // four pixel color
        Color pixela, pixelb, pixelc, pixeld;
        // alpha and beta
        double alpha, beta;
        // ifirst and jfirst
        int ifirst, jfirst;
        // red, green, and blue value
        int red, green, blue;
        // ratio x and y
        double ratiox = (double) width/(sourceimage.getWidth()-1);
        double ratioy = (double) height/(sourceimage.getHeight()-1);
//        System.out.println(sourceimage.getWidth()+","+sourceimage.getHeight());
//        System.out.println(ratiox+","+ratioy);
//        System.out.println(width+","+height);
        
        // new width and height
        width = (int) (ratiox*(sourceimage.getWidth()-1));
        height = (int) (ratioy*(sourceimage.getHeight()-1));
        System.out.println("new zooming : "+width+" x "+height);
        BufferedImage imageresult = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        for(int i=0;i<sourceimage.getWidth()-1;i++)
        {
            for(int j=0;j<sourceimage.getHeight()-1;j++)
            {
                // get the 4 pixel color
                pixela = Helper.getColor(sourceimage, i, j);
                pixelb = Helper.getColor(sourceimage, i+1, j);
                pixelc = Helper.getColor(sourceimage, i, j+1);
                pixeld = Helper.getColor(sourceimage, i+1, j+1);
                
                ifirst = (int) (i*ratiox);
                for(int ir=ifirst;ir<ifirst+ratiox;ir++)
                {
                    // calculate alpha
                    alpha = (double) (ir-ifirst)/ratiox;
                    
                    jfirst = (int) (j*ratioy);
                    for(int jr=jfirst;jr<jfirst+ratioy;jr++)
                    {
                        // calculate beta
                        beta = (double) (jr-jfirst)/ratioy;
                        
                        // calculate red, green, blue value
                        red = (int) ((1-alpha)*((1-beta)*pixela.getRed()+beta*pixelc.getRed()) + 
                                       alpha*((1-beta)*pixelb.getRed()+beta*pixeld.getRed()));
                        green = (int) ((1-alpha)*((1-beta)*pixela.getGreen()+beta*pixelc.getGreen()) + 
                                       alpha*((1-beta)*pixelb.getGreen()+beta*pixeld.getGreen()));
                        blue = (int) ((1-alpha)*((1-beta)*pixela.getBlue()+beta*pixelc.getBlue()) + 
                                       alpha*((1-beta)*pixelb.getBlue()+beta*pixeld.getBlue()));
                        
                        color = new Color(red, green, blue);
//                        System.out.println("poin("+ir+","+jr+"): red="+red+", green="+green+", blue="+blue);
                        
                        // check whether it still in the border or not
                        if(ir<width && jr<height)
                        {
                            imageresult.setRGB(ir, jr, color.getRGB());
                        }
                    }
                }
            }
        }
        
        return imageresult;
    }
    
    /**
     * This is procedure will use the bilinear algorithm.
     * <P>Last update 01/04/2013 by d_frEak.
     * 
     * @param sourceimage the image source.
     * @param ratio the ratio of zooming (0-1 to zoom out and >1 to zoom in).
     * @param compareimage the image that will be compared to image result.
     * @return image result.
     * @since 09/03/2013
     */
    static public ImageContainer Bilinear(BufferedImage sourceimage, double ratio, BufferedImage compareimage)
    {
        BufferedImage result=Bilinear(sourceimage, ratio);
        if(result==null)
        {
            return null;
        }
        return Helper.imageCompare(result, compareimage);
    }
    
    /* ================================================================================================================= *
     * TAG: Gradien Analyzing with Polynomial Approach =========================================================================== *
     * ================================================================================================================= */ 
    
    /**
     * This is procedure will use the polynomial algorithm.
     * <P>Last update 08/04/2013 by d_frEak.
     * 
     * @param sourceimage the image source.
     * @param ratio the ratio of zooming (0-1 to zoom out and >1 to zoom in).
     * @param power the power of the polynomial.
     * @return image result.
     * @since 01/04/2013
     */
    static public BufferedImage Polynomial(BufferedImage sourceimage, double ratio, int power)
    {
        // check whether sourceimage is null
        if(sourceimage==null)
        {
            return null;
        }
        // check whether ratio is negative
        if(ratio<0)
        {
            return null;
        }
        // check the power
        if(power<1)
        {
            return null;
        }
        
        int width = (int) (sourceimage.getWidth()*ratio);
        int height = (int) (sourceimage.getHeight()*ratio);
        
        Color color;
        
        // four pixel color
        Color pixela, pixelb, pixelc, pixeld;
        // alpha and beta
        double alpha, beta;
        // ifirst and jfirst
        int ifirst, jfirst;
        // red, green, and blue value
        int red, green, blue;
        // ratio x and y
        double ratiox = (double) width/(sourceimage.getWidth()-1);
        double ratioy = (double) height/(sourceimage.getHeight()-1);
        
        // new width and height
        width = (int) (ratiox*(sourceimage.getWidth()-1));
        height = (int) (ratioy*(sourceimage.getHeight()-1));
        System.out.println("new zooming : "+width+" x "+height);
        BufferedImage imageresult = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        // temporary gradient x and y
        double gradx,grady;
        // temporary pixel
        Color pixeltemp1, pixeltemp2, pixeltemp3, pixeltemp4, pixeltemp5, pixeltemp6;
        // temporary array for gradient
        double grad[][]=new double[sourceimage.getHeight()][sourceimage.getWidth()];
        
        // generate a matrix gradient
        // first and last column and row set to 0
        for(int i=0;i<sourceimage.getWidth();i++)
        {
            grad[0][i]=0;
            grad[sourceimage.getHeight()-1][i]=0;
        }
        for(int j=0;j<sourceimage.getHeight();j++)
        {
            grad[j][0]=0;
            grad[j][sourceimage.getWidth()-1]=0;
        }
        // calculate the rest
        for(int i=1;i<sourceimage.getWidth()-1;i++)
        {
            for(int j=1;j<sourceimage.getHeight()-1;j++)
            {
                // get the 6 pixel color
                pixeltemp1 = Helper.getColor(sourceimage, i+1, j);
                pixeltemp2 = Helper.getColor(sourceimage, i-1, j);
                pixeltemp3 = Helper.getColor(sourceimage, i+1, j+1);
                pixeltemp4 = Helper.getColor(sourceimage, i-1, j+1);
                pixeltemp5 = Helper.getColor(sourceimage, i+1, j-1);
                pixeltemp6 = Helper.getColor(sourceimage, i-1, j-1);
                // calculate gradx
                gradx=2*((pixeltemp1.getRed()+pixeltemp1.getGreen()+pixeltemp1.getBlue())
                        -(pixeltemp2.getRed()+pixeltemp2.getGreen()+pixeltemp2.getBlue()))
                        +((pixeltemp3.getRed()+pixeltemp3.getGreen()+pixeltemp3.getBlue())
                        -(pixeltemp4.getRed()+pixeltemp4.getGreen()+pixeltemp4.getBlue()))
                        +((pixeltemp5.getRed()+pixeltemp5.getGreen()+pixeltemp5.getBlue())
                        -(pixeltemp6.getRed()+pixeltemp6.getGreen()+pixeltemp6.getBlue()));
                
                // get the 6 pixel color
                pixeltemp1 = Helper.getColor(sourceimage, i, j+1);
                pixeltemp2 = Helper.getColor(sourceimage, i, j-1);
                pixeltemp3 = Helper.getColor(sourceimage, i-1, j+1);
                pixeltemp4 = Helper.getColor(sourceimage, i-1, j-1);
                pixeltemp5 = Helper.getColor(sourceimage, i+1, j+1);
                pixeltemp6 = Helper.getColor(sourceimage, i+1, j-1);
                // calculate gradx
                grady=2*((pixeltemp1.getRed()+pixeltemp1.getGreen()+pixeltemp1.getBlue())
                        -(pixeltemp2.getRed()+pixeltemp2.getGreen()+pixeltemp2.getBlue()))
                        +((pixeltemp3.getRed()+pixeltemp3.getGreen()+pixeltemp3.getBlue())
                        -(pixeltemp4.getRed()+pixeltemp4.getGreen()+pixeltemp4.getBlue()))
                        +((pixeltemp5.getRed()+pixeltemp5.getGreen()+pixeltemp5.getBlue())
                        -(pixeltemp6.getRed()+pixeltemp6.getGreen()+pixeltemp6.getBlue()));
                
                // calcalate grad^2
                grad[j][i]=Math.pow(gradx,2)+Math.pow(grady,2);
            }
        }
        
        for(int i=0;i<sourceimage.getWidth()-1;i++)
        {
            for(int j=0;j<sourceimage.getHeight()-1;j++)
            {
                // get the 4 pixel color
                pixela = Helper.getColor(sourceimage, i, j);
                pixelb = Helper.getColor(sourceimage, i+1, j);
                pixelc = Helper.getColor(sourceimage, i, j+1);
                pixeld = Helper.getColor(sourceimage, i+1, j+1);
                
                ifirst = (int) (i*ratiox);
                for(int ir=ifirst;ir<ifirst+ratiox;ir++)
                {
                    // calculate alpha
                    // check the grad
                    if(grad[j][i]<grad[j][i+1])
                    {
                        alpha = (double) Math.pow(ir-ifirst, power)/Math.pow(ratiox, power);
                    }
                    else
                    {
                        alpha = (double) 1-Math.pow(ifirst+ratiox-ir, power)/Math.pow(ratiox, power);
                    }
                    
                    jfirst = (int) (j*ratioy);
                    for(int jr=jfirst;jr<jfirst+ratioy;jr++)
                    {
                        // calculate beta
                        // check the grad
                        if(grad[j][i]<grad[j+1][i])
                        {
                            beta = (double) Math.pow(jr-jfirst, power)/Math.pow(ratioy, power);
                        }
                        else
                        {
                            beta = (double) 1-Math.pow(jfirst+ratioy-jr, power)/Math.pow(ratioy, power);
                        }
                        
                        // calculate red, green, blue value
                        red = (int) ((1-alpha)*((1-beta)*pixela.getRed()+beta*pixelc.getRed()) + 
                                    alpha*((1-beta)*pixelb.getRed()+beta*pixeld.getRed()));
                        green = (int) ((1-alpha)*((1-beta)*pixela.getGreen()+beta*pixelc.getGreen()) + 
                                    alpha*((1-beta)*pixelb.getGreen()+beta*pixeld.getGreen()));
                        blue = (int) ((1-alpha)*((1-beta)*pixela.getBlue()+beta*pixelc.getBlue()) + 
                                    alpha*((1-beta)*pixelb.getBlue()+beta*pixeld.getBlue()));

                        color = new Color(red, green, blue);
//                        System.out.println("poin("+ir+","+jr+"): red="+red+", green="+green+", blue="+blue);

                        // check whether it still in the border or not
                        if(ir<width && jr<height)
                        {
                            imageresult.setRGB(ir, jr, color.getRGB());
                        }
                    }
                }
            }
        }
        
        return imageresult;
    }
    
    /**
     * This is procedure will use the polynomial algorithm.
     * <P>Last update 08/04/2013 by d_frEak.
     * 
     * @param sourceimage the image source.
     * @param ratio the ratio of zooming (0-1 to zoom out and >1 to zoom in).
     * @param power the power of the polynomial.
     * @param compareimage the image that will be compared to image result.
     * @return image result.
     * @since 01/04/2013
     */
    static public ImageContainer Polynomial(BufferedImage sourceimage, double ratio, int power, BufferedImage compareimage)
    {
        BufferedImage result=Polynomial(sourceimage, ratio, power);
        if(result==null)
        {
            return null;
        }
        return Helper.imageCompare(result, compareimage);
    }
}
