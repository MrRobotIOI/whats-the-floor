/**
 * EECS 2011 Z, Winter 2023
 * Name: Chizimuzo Ikejiani 
 * Student Number: 219091180 
 * Resources Consulted 
 * https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html#Hashtable-int- 
 * 
 * Assignment 3, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 */
package A3;
// Do NOT modify the package declaration
// Do NOT add any import
/**
 * Your own implementation of a HashTable class.
 * Add the appropriate fields and methods you want in order to solve this problem.
 */
class HashTable {

    // TODO: implement your own HashTable class
public static int[] hashArray;
	public static int size;
	
	public boolean containsKey(long key) {
		if (key<0) {
			key=Math.abs(key);
		}
		if (key > 2750000 || key < 0)
		{
			return false;
		}
		
		if (hashArray[(int) key] == 1)
		{
			
			return true;
		}
		return false;
	}
	public int size() {
		
		
		return size;
		
	}
	public HashTable(int sz) {
		
		hashArray=new int[(int) sz];
		size=0;
		
	}
public int get(int s) {

	return (int) hashArray[(int) s];
}

	public int put(long sol, int i) {
		++size;
		if(sol<0) {
			sol=Math.abs(sol);
			hashArray[(int) sol]=1;
			return (int) (sol);
		}
		else {
		hashArray[(int) sol]=1;
		return (int) sol;
		}
		
	}
}
public class A3Q2 {

    /**
     * Return the number of unique integer solutions where each integer is in the range [-50, 50].
     * The equation is given in the handout.
     * Precondition: A, B, C, D, E, S are integers in the range [-5000, 5000]
     * Note that the return value of this function is a long integer, not just an int.
     *
     * Do NOT modify the signature of this function.
     */
    static long solve(int A, int B, int C, int D, int E, int S) {

        // TODO: implement this function
        HashTable tab1 = new HashTable(250000);
		
		long count =0;
		long i = 0 ;
	
		for(int x = -50; x<=50; x++) {
			long x1=A*x;
		
		
		tab1.put(x1,  x);
			
			
		}

			    // Iterate over all possible values of x1 to x5
			 
			        for (int x2 = -50; x2 <= 50; x2++) {
			            for (int x3 = -50; x3 <= 50; x3++) {
			                for (int x4 = -50; x4 <= 50; x4++) {
			                    for (int x5 = -50; x5 <= 50; x5++) {
			                        
			                        

			                       
			                       
			                        int sol= B*x2*x2 + C*x3*x3*x3 + D*x4*x4*x4*x4 + E*x5*x5*x5*x5*x5;
			                        long s = 0;
			                        s =S-sol;
			                       
			                        i++;
			                       
			                         if(s<250000 && s>-250000&&tab1.containsKey(s)==true)
			                        	{
			                        	++count;
			                        	}
			                        
			                        }
				                       
		                        		
		                        	}
			                        
			                            
			                        
			                }
			            }
			        if(A == 0) {
				        count= i*tab1.size();	
				        return count;
				        }
			        	
			        		
			        
			  
			  
			        return count;
    }

    public static void main(String[] args) {

        // Below are a few test cases.
        // Printing "true" means the return value is correct.
        // Each call to solve() must take less than 5 seconds.

        System.out.println(340 == solve(12, 34, 56, 78, 9, 10));
        System.out.println(16665 == solve(20, -11, -2, 0, 11, -2011));
        System.out.println(10510100501L == solve(0, 0, 0, 0, 0, 0));
    }
}
