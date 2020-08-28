import edu.princeton.cs.algs4.StdIn;

public class Permutation {
   public static void main(String[] args)
   {
	 
	   int k=Integer.parseInt(args[0]);
	   
	   
	   RandomizedQueue<String> obj1=new RandomizedQueue<>();
	  
	   
	   while(!StdIn.isEmpty())
	   {
		   obj1.enqueue(StdIn.readString());
	   }
	   
	   for(int i=0;i<k;i++)
	   {
		   System.out.println(obj1.dequeue());
	   }
	   
	   
	   
   }
}