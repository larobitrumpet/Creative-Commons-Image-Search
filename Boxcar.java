/**
 * Tim McGowen
 * 9/20/2015
 *
 * Luke Robillard
 * 3/10/2021
 */
public class Boxcar<T>
{
    // instance variables
    private T data;
    private Boxcar<T> next;

    /**
     * Constructor for objects of class Boxcar
     */
    public Boxcar(T s)
    {
        // initialise instance variables
        data = s;
        next = null;
    }

    /**
     * Set link to next boxcar
     */
    public void setNext(Boxcar<T> n)
    {
        next = n;
    }
    
    /**
     * Get link to next boxcar
     */
    public Boxcar<T> next()
    {
        return next;
    }
    
    /**
     * Set data in boxcar
     */
    public void setData(T s)
    {
        data = s;
    }
    
    /**
     * Get data from boxcar
     */
    public T data()
    {
        return data;
    }

    /**
     * Convert to string
     */
    public String toString()
    {
      return this.data().toString();
    }
}
