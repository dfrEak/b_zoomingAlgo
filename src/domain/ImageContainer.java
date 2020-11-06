package domain;

import java.awt.image.BufferedImage;

/**
 * ImageContainer Class.
 * <P>This is a container to the image.
 * <P>Last update 01/04/2013 by d_frEak.
 * 
 * @author d_frEak
 * @version 1.0
 * @since 01/04/2013
 */
public class ImageContainer {
    
    /**
    * The image.
    */
    private BufferedImage image;
    
    /**
    * The mean squared error of the image.
    */
    private double mse;
    
    /**
    * The mean squared error of the red color.
    */
    private double msered;
    
    /**
    * The mean squared error of the green color.
    */
    private double msegreen;
    
    /**
    * The mean squared error of the blue color.
    */
    private double mseblue;
    
    /**
    * The Peak Signal-to-Noise Ratio of the image.
    */
    private double psnr;
    
    /**
    * The Peak Signal-to-Noise Ratio of the red color.
    */
    private double psnrred;
    
    /**
    * The Peak Signal-to-Noise Ratio of the green color.
    */
    private double psnrgreen;
    
    /**
    * The Peak Signal-to-Noise Ratio of the blue color.
    */
    private double psnrblue;
    
    /**
    * The Cross Correlation of the image.
    */
    private double crosscorrelation;
    
    /**
    * The Cross Correlation of the red color.
    */
    private double crosscorrelationred;
    
    /**
    * The Cross Correlation of the green color.
    */
    private double crosscorrelationgreen;
    
    /**
    * The Cross Correlation of the blue color.
    */
    private double crosscorrelationblue;

    /**
    * Getter for crosscorrelation.
    */
    public double getCrosscorrelation() {
        return crosscorrelation;
    }

    /**
    * Setter for crosscorrelation.
    */
    public void setCrosscorrelation(double crosscorrelation) {
        this.crosscorrelation = crosscorrelation;
    }

    /**
    * Getter for crosscorrelationblue.
    */
    public double getCrosscorrelationblue() {
        return crosscorrelationblue;
    }

    /**
    * Setter for crosscorrelationblue.
    */
    public void setCrosscorrelationblue(double crosscorrelationblue) {
        this.crosscorrelationblue = crosscorrelationblue;
    }

    /**
    * Getter for crosscorrelationgreen.
    */
    public double getCrosscorrelationgreen() {
        return crosscorrelationgreen;
    }

    /**
    * Setter for crosscorrelationgreen.
    */
    public void setCrosscorrelationgreen(double crosscorrelationgreen) {
        this.crosscorrelationgreen = crosscorrelationgreen;
    }

    /**
    * Getter for crosscorrelationred.
    */
    public double getCrosscorrelationred() {
        return crosscorrelationred;
    }

    /**
    * Setter for crosscorrelationred.
    */
    public void setCrosscorrelationred(double crosscorrelationred) {
        this.crosscorrelationred = crosscorrelationred;
    }

    /**
    * Getter for mseblue.
    */
    public double getMseblue() {
        return mseblue;
    }

    /**
    * Setter for mseblue.
    */
    public void setMseblue(double mseblue) {
        this.mseblue = mseblue;
    }

    /**
    * Getter for msegreen.
    */
    public double getMsegreen() {
        return msegreen;
    }

    /**
    * Setter for msegreen.
    */
    public void setMsegreen(double msegreen) {
        this.msegreen = msegreen;
    }

    /**
    * Getter for msered.
    */
    public double getMsered() {
        return msered;
    }

    /**
    * Setter for msered.
    */
    public void setMsered(double msered) {
        this.msered = msered;
    }

    /**
    * Getter for psnrblue.
    */
    public double getPsnrblue() {
        return psnrblue;
    }

    /**
    * Setter for psnrblue.
    */
    public void setPsnrblue(double psnrblue) {
        this.psnrblue = psnrblue;
    }

    /**
    * Getter for psnrgreen.
    */
    public double getPsnrgreen() {
        return psnrgreen;
    }

    /**
    * Setter for psnrgreen.
    */
    public void setPsnrgreen(double psnrgreen) {
        this.psnrgreen = psnrgreen;
    }

    /**
    * Getter for psnrred.
    */
    public double getPsnrred() {
        return psnrred;
    }

    /**
    * Setter for psnrred.
    */
    public void setPsnrred(double psnrred) {
        this.psnrred = psnrred;
    }

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
    * Getter for mse.
    */
    public double getMse() {
        return mse;
    }

    /**
    * Setter for mse.
    */
    public void setMse(double mse) {
        this.mse = mse;
    }

    /**
    * Getter for psnr.
    */
    public double getPsnr() {
        return psnr;
    }

    /**
    * Setter for psnr.
    */
    public void setPsnr(double psnr) {
        this.psnr = psnr;
    }
}
