import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


//IllegalArgumentException left to solve
//Performance Requirements OKAY!!

public class Deque<Item> implements Iterable<Item> {

	private Node first,last;
	private int N;
	
	private class Node{
		Item item;
		Node next;
		Node prev;
	}
	
	
    // construct an empty deque
    public Deque()
    {
    	N=0; 
    	first=null;
    	last=null;
    }

    // is the deque empty?
    public boolean isEmpty()
    {
    	return first==null;
    }
   

    // return the number of items on the deque
    public int size()
    {
    	return N;
    }

    // add the item to the front
    public void addFirst(Item item)
    {
    	
    	if(item==null) 
   		 throw new IllegalArgumentException();
    	
    	if(isEmpty())
    	{
    		first=new Node();
    		first.item=item;
    		last=first;
    		first.next=null;
    		first.prev=null;
    		N++;
    	}
    	else
    	{
    		Node oldfirst=first;
    		first=new Node();
    		first.item=item;
    		first.prev=null;
    		first.next=oldfirst;
    		oldfirst.prev=first;
    		N++;
    	}
    }

    // add the item to the back
    public void addLast(Item item)
    {
    	if(item==null) 
   		 throw new IllegalArgumentException();
    	
    	if(isEmpty())
    	{
    		last=new Node();
    		last.item=item;
    		first=last;
    		last.prev=null;
    		last.next=null;
    		N++;
    	}
    	else
    	{
    		Node oldlast=last;
    		last=new Node();
    		last.item=item;
    		last.next=null;
    		last.prev=oldlast;
    		oldlast.next=last;
    		N++;
    	}
    }

    // remove and return the item from the front
    public Item removeFirst()
    {
    	if(isEmpty())
    	{
    		throw new NoSuchElementException("The Deque is Empty!!");
    	}
    	else if(first==last)
    	{
    		Item item=first.item;
    		first=null;
    		last=null;
    		N--;
    		return item;
    		
    	}
    	else
    	{
    		 Item item=first.item;
    		 first=first.next;
    		 first.prev=null;
    		 N--;
    		 return item;
    		
    	}
    }

    // remove and return the item from the back
    public Item removeLast()
    {
    	if(isEmpty())
    	{
    		throw new NoSuchElementException("The Deque is Empty!!");
    	}
    	else if(first==last)
    	{
    		Item item=last.item;
    		last=null;
    		first=null;
    		N--;
    		return item;
    		
    	}
    	else
    	{
    		Item item=last.item;
    		last=last.prev;
    		last.next=null;
    		N--;
    		return item;
    		
    	}
    	
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
    {
    	return new FrontToBack();
    	
    }
    
    private class FrontToBack implements Iterator<Item>
    {
    	private Node current=first;
    	
    	public boolean hasNext()
    	{
    		return current!=null;
    	}
    	
    	public void remove()
    	{
    		throw new UnsupportedOperationException();
    	}
    	
    	public Item next()
    	{
    		if(!hasNext())
    			throw new NoSuchElementException();
    		Item item=current.item;
    		current=current.next;
    		return item;
    	}
    }
    
    

    // unit testing (required)
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	int o;
    	Deque<Integer> obj=new Deque<Integer>();
    	
    	char ch='y';
    	while(ch=='y')
    	{
    		System.out.println("Do you want to: ");
        	System.out.println("1. AddFirst: ");
        	System.out.println("2. AddLast: ");
        	System.out.println("3. RemoveFirst: ");
        	System.out.println("4. RemoveLast: ");
        	System.out.println("5. Traverse: ");
        	System.out.println("6. Size of queue: ");
        	System.out.println("7. Exit: ");
        	o=sc.nextInt();
        	
    		switch(o)
  
	    	{
	    	case 1: System.out.println("Enter the element to add: ");
	    			int i=sc.nextInt();
	    			obj.addFirst(i);
	    			break;
	    	case 2: System.out.println("Enter the element to add: ");
					int j=sc.nextInt();
					obj.addLast(j);
					break;
	    	case 3: System.out.println("The item "+obj.removeFirst()+" is removed!!");
	    			break;
	    	case 4: System.out.println("The item "+obj.removeLast()+" is removed!!");
					break;
	    	case 5: System.out.println("The items in the queue are: ");
	    			if(obj.isEmpty())
	    				System.out.println("No items to display!!");
	    			
	    			else {
	    					
			    			Iterator<Integer> itr=obj.iterator();
			    			while(itr.hasNext())
			    			{
			    				System.out.println(itr.next());
			    			}
	    				}
	    			break;
	    	case 6: System.out.println("The size is: "+obj.size());
	    			break;
	    	case 7: ch='n';
	    			break;
	    	default: System.out.println("Wrong input!!");
	    	}
    	}
    	sc.close();
    	
    	
    }

}