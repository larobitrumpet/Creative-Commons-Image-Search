
/**
 * GenericList - Generic String List
 * 
 * @author Luke Robillard
 * @version version 1.0
 */
public class GenericList<X>
{
  // Use an array to create the list
  private X[] arr;
  private int size;
  private final double EXPAND_SIZE = 1.2; // Expand by 20%

  /*
   * Constructor for objects of class GenericList
   */
  public GenericList()
  {
    this.newArray();
  }

  /*
   * size - returns the size of the list
   * 
   * return - the size of the list as an integer
   */
  public int size()
  {
    return size;
  }

  private void newArray()
  {
    arr = (X[]) new Object[10];
    size = 0;
  }

  /*
   * expandArray - expandArrays arr by EXPAND_SIZE
   */
  private void expandArray()
  {
    X[] arr2;
    arr2 = (X[]) new Object[(int)(arr.length * EXPAND_SIZE)];
    // Copy elements from arr to arr2
    for (int i = 0; i < arr.length; i++)
      arr2[i] = arr[i];
    // Have arr point to new array
    arr = arr2;
    // Old array will be Garbage Collected
    System.gc();
  }

  /*
   * add - add one value to the list in the next available position
   * 
   * param - element to add to the list
   */
  public void add(X value)
  {
    if (size == arr.length) // Is arr full? Then expandArray
    {
      this.expandArray();
    }

    arr[size] = value;
    size++;
  }

  /*
   * set - sets the element at index to value
   *
   * param - index to set, must point to an element already in the list
   * param - new value to set the element to
   */
  public void set(int index, X value)
  {
    if (index >= 0 && index < size)
    {
      arr[index] = value;
    }
    else
    {
      //throw new IllegalArgumentException(String.format("Index '%d' is not in list.", index));
      System.out.printf("Index '%d' is not in list.", index);
    }
  }

  /*
   * get - return the value at the specified location in the list
   * 
   * param - index into the list for the value to return
   * return - value at index
   */
  public X get(int index)
  {
    if (index >= 0 && index < size)
    {
      return arr[index];
    }
    else
    {
      //throw new IllegalArgumentException(String.format("Index '%d' is not in list.", index));
      System.out.printf("Index '%d' is not in list.", index);
      return (X) new Object();
    }
  }

  /*
   * clear - empty the list
   */
  public void clear()
  {
    this.newArray();
  }

  /*
   * insert - insert new element at indicated index
   * 
   * param - index to insert new element
   * param - value of new element
   */
  public void insert(int index, X value)
  {
    // If the index points to an empty element, add it.
    if ( index >= size )
      add(value);
    else if (index < 0)
    {
      //throw new IllegalArgumentException(String.format("Index '%d' is not in list.", index));
      System.out.printf("Index '%d' is not in list.", index);
    }
    else
    {
      if (size == arr.length) // Is arr full? Then expandArray by 20%
      {
          this.expandArray();
      }
      // Open a hole to insert the value
      for (int i = size; i > index; i--)
        arr[i] = arr[i - 1];
      arr[index] = value;
      size++;
    }
  }

  /*
   * remove - remove the element at index and moves elements to fill the hole created
   *
   * param - the index to remove, must already be in the array
   */
  public void remove(int index)
  {
    if (index >= 0 && index < size)
    {
      for (int i = index; i < size - 1; i++)
      {
        arr[i] = arr[i + 1];
      }
      size--;
    }
    else
    {
      //throw new IllegalArgumentException(String.format("Index '%d' is not in list.", index));
      System.out.printf("Index '%d' is not in list.", index);
    }
  }

  /*
   * toString - return a string value that represents the list
   *
   * return - String
   */
  public String toString()
  {
    String returnValue = String.valueOf(arr[0]);
    for (int i = 1; i < size; i++)
      returnValue = returnValue + ", " + arr[i];
    return returnValue;
  }

  /*
   * display - display the list
   */
  public void display()
  {
    for (int i = 0; i < size; i++)
      System.out.println(i + ": " + arr[i]);
    if ( arr.length == size)
      System.out.println("List is full\n");
    else
      System.out.println("List has " + (arr.length - size) + " spaces left\n");
  }
}

