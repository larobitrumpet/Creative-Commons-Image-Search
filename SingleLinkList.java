/*
 * Tim McGowen
 * 9/20/2015
 *
 * Luke Robillard
 * 3/10/2021
 */
public class SingleLinkList<T>
{
    // The engine to our train of boxcars
    private Boxcar<T> head;
    private Boxcar<T> tail;
    private int size;

    /**
     * Constructor for objects of class SingleLinkList
     */
    public SingleLinkList()
    {
        // initialise instance variables
        this.clear();
    }
    
    /**
     * Display linked list
     */
    public String toString()
    {
/*        String s = "top";
        Boxcar<T> boxcar = head;
        if (head != null)
        {
            s += ", " + boxcar.data().toString();
            while (boxcar.next() != null)
            {
                boxcar = boxcar.next();
                s += ", " + boxcar.data().toString();
            }
        }
        s += ", bottom";
        return s;*/
/*        String s = "engine";
        if (head != null)
        {
            Boxcar<T> boxcar = head;
            do {
              s = s + "->" + boxcar.data().toString();
              boxcar = boxcar.next();
            } while (boxcar != null);
        }
        return s;*/
      String s = "";
      Boxcar<T> boxcar = head;

      if (head == null)
      {
        return "";
      }
      else
      {
        String data = boxcar.data();
        s = data.toString();
        while ( boxcar.next() != null )
        {
          boxcar = boxcar.next();
          data = boxcar.data();
          s = s + "," + data.toString();
        }
      }
      return s;
    }
    
     /**
     * Return size of linked list
     */
    public int size()
    {
        return size;
    }

    public void clear()
    {
      head = null;
      tail = null;
      size = 0;
      System.gc();
    }
    
    /**
     * Add boxcar to end
     */
    public void addBoxcarToEnd(Boxcar<T> b)
    {
      if (size == 0)
      {
        head = b;
        tail = b;
      }
      else
      {
        tail.setNext(b);
        tail = b;
      }
      size++;
    }
    
    /**
     * Add boxcar to front
     */
    public void addBoxcarToFront(Boxcar<T> b)
    {
      // Enter your code for addBoxcarToFront
      if (size == 0)
      {
        tail = b;
      }
      else
      {
        b.setNext(head);
      }
      head = b;
      size++;
    }
    
    /**
     * Remove boxcar from front
     */
    public void removeBoxcarFromFront() throws IndexOutOfBoundsException
    {
      // Enter your code for removeBoxcarFromFront
      if (size == 0)
      {
        //throw new IndexOutOfBoundsException("Cannot remove element from empty list");
        return;
      }
      else if (size == 1)
      {
        this.clear();
      }
      else
      {
        head = head.next();
        size--;
        System.gc();
      }
    }
    
    /**
     * Remove boxcar from end
     */
    public void removeBoxcarFromEnd() throws IndexOutOfBoundsException
    {
      if (size == 0)
      {
        //throw new IndexOutOfBoundsException("Cannot remove element from empty list");
        return;
      }
      else if (size == 1)
      {
        this.clear();
      }
      else
      {
        Boxcar<T> boxcar = head;
        Boxcar<T> prevBoxcar = head;
        while (boxcar.next() != null)
        {
          prevBoxcar = boxcar;
          boxcar = boxcar.next();
        }
        prevBoxcar.setNext(null);
        tail = prevBoxcar;
        size--;
        System.gc();
      }
    }

    /*
     * add - add one value to the list in the next available position
     *       We choose to add to the end of the linked list
     *
     * param - value to add to the list
     */
    public void add(T value)
    {
      Boxcar<T> boxcar = new Boxcar(value);
      this.addBoxcarToEnd(boxcar);
    }

    /*
     * getBoxcar - gets the boxcar at the specified location in the list
     *
     * param - index into the list for the boxcar to return
     *
     * returns - boxcar at parameter
     */
    private Boxcar<T> getBoxcar(int index) throws ArrayIndexOutOfBoundsException
    {
      // No index is valid if there are no entries in the linked list
      if (this.size == 0)
        throw new ArrayIndexOutOfBoundsException();
      else if (index < 0 || index >= this.size)
        throw new ArrayIndexOutOfBoundsException();
      else if (index == 0)
        return head;
      else if (index == size - 1)
        return tail;
      else
      {
        // Walk the linked list until you get to the indexed value
        int walk = 0;
        Boxcar<T> boxcar = head;
        while (walk < index)
        {
          boxcar = boxcar.next();
          walk++;
        }
        return boxcar;
      }
    }

    /*
     * get - return the value at the specified location in the list
     *
     * param - index into the list for the value to return
     *
     * returns - value at parameter
     */
    public T get(int index) throws ArrayIndexOutOfBoundsException
    {
      return this.getBoxcar(index).data();
    }

    /*
     * set - set value at indicated index
     *
     * param - index to set new value
     * param - value of new element
     */
    public void set(int index, T value) throws ArrayIndexOutOfBoundsException
    {
      this.getBoxcar(index).setData(value);
    }

    /*
     * swap - swap data between the two index values
     *
     * param - index 1
     * param - index 2
     *
     * The data at index1 is saved to index2 and the data at index2
     * is saved to index1.
     */
    public void swap(int index1, int index2) throws ArrayIndexOutOfBoundsException
    {
      Boxcar<T> boxcar1 = getBoxcar(index1);
      Boxcar<T> boxcar2 = getBoxcar(index2);
      T tmp = boxcar1.data();
      boxcar1.setData(boxcar2.data());
      boxcar2.setData(tmp);
    }

    /*
     * push - push a value on the stack
     * 
     * param - value to add to the top of stack
     */
    public void push(T value)
    {
        Boxcar<T> boxcar = new Boxcar<T>(value);
        addBoxcarToFront(boxcar);
    }

    /*
     * pop - return the value at the top of stack
     * 
     * returns - value at top of stack
     */
    public T pop() throws ArrayIndexOutOfBoundsException
    {
        T value = get(0);
        removeBoxcarFromFront();
        return value;
    }

    /*
     * peek - return value at top of stack but do not remove it.
     * 
     */
    public T peek() throws ArrayIndexOutOfBoundsException
    {
        return get(0);
    }

    /*
     * isEmpty - returns true if stack is empty. Otherwise false.
     * 
     */
    public boolean isEmpty()
    {
        return this.size() == 0;
    }
}
