package util;

/**
 * Polinomial Class.
 * <P>This is a singleton class that contains the polynomial function.
 * <P>Last update 01/04/2013 by d_frEak.
 * 
 * @author d_frEak
 * @version 1.0
 * @since 09/03/2013
 */
public class Polynomial {
    
    /**
    * The singleton variable.
    */
    static private Polynomial polynomial=null;
    
    /**
    * The singleton procedure.
    */
    public static Polynomial Singleton()
    {
        if(polynomial == null)
        {
            polynomial = new Polynomial();
        }
        return polynomial;
    }
    
    /**
    * The power.
    */
    private int power=1;

    /**
    * Getter for power.
    */
    public int getPower() {
        return power;
    }

    /**
    * Setter for power.
    */
    public void setPower(int power) {
        this.power = power;
    }
}
