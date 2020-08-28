import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

//IllegalArgumentException left to solve
//Performance Requirements OKAY!!

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item s[];
	private int N;
	
	
    // construct an empty randomized queue
    public RandomizedQueue()
    {
    	s=(Item[]) new Object[2];
    	N=0;
    }

    // is the randomized queue empty?
    public boolean isEmpty()
    {
    	return N==0;
    }

    // return the number of items on the randomized queue
    public int size()
    {
    	return N;
    }
    
    //resizing the array
    private void resize(int capacity)
    {
    	Item copy[]=(Item[]) new Object[capacity];
    	for(int i=0;i<N;i++)
    	{
    		copy[i]=s[i];
    	}
    	s=copy;
    	
    }

    // add the item
    public void enqueue(Item item)
    {
    	if(item==null) 
    		 throw new IllegalArgumentException();
    	if(s.length==N) //if the array is full
    		resize(2*s.length);
    	
    		s[N++]=item;
    		
    	
    	
    	
//    	  if randomly insert the element to the queue
//    	  but since we are shuffeling we need not insert 
//    	  in random order and can normaly insert at the back.
//    	int random=StdRandom.uniform(N);  
//    	Item temp=s[random];
//    	s[random]=temp;
//    	s[N++]=temp;
    }

    // remove and return a random item
    public Item dequeue()
    {
    	if(isEmpty())
    	{
    		throw new NoSuchElementException("Queue is empty!!");
    	}
    	if(N>0 && N==s.length/4)
			resize(s.length/2);
  
    		int random=StdRandom.uniform(N);
    		Item item=s[random];
    		s[random]=s[N-1];
    		s[N-1]=null;
    		N--;
    		
    		
    		return item;
    		
    		
    	
		
    	
    }

    // return a random item (but do not remove it)
    public Item sample()
    {
    	if(isEmpty())
    	{
    		throw new NoSuchElementException("Queue is empty!!");
    	}
    	else
    	{
    		int random=StdRandom.uniform(N);
        	return s[random];
    	}
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
    {
    	return new RandomQueueIterator();
    }
    
    private class RandomQueueIterator implements Iterator<Item>
    {
    	private int current;
    	final private int randind[];  //stores the random indices of the queue
    	
    	public RandomQueueIterator()
    	{
    		current=0;
    		randind=new int[N];
    		for(int i=0;i<N;i++)
    		{
    			randind[i]=i;
    		}
    		StdRandom.shuffle(randind);
    			
    	}
    	
    	public boolean hasNext()
    	{
    		return current<N;
    	}
    	
    	public void remove()
    	{
    		throw new UnsupportedOperationException();
    	}
    	public Item next()
    	{
    		if(!hasNext())
    			throw new NoSuchElementException();
    		else
    		
    			return s[randind[current++]];
    		
    	}
    }
    

    // unit testing (required)
    public static void main(String[] args)
    {
    	int n = 5;
    	RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
    	for (int i = 0; i < n; i++)
    	    queue.enqueue(i);
    	for (int a : queue) {
    	    for (int b : queue)
    	        StdOut.print(a + "-" + b + " ");
    	    StdOut.println();
    	}
    	
    	
    }

}