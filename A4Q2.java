/**
 * Name: Chizimuzo Ikejiani
 * Student Number: 219091180
 * 
 * EECS 2011 Z, Winter 2023
 * Assignment 4, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 */
package A4;
// Do NOT modify the package declaration
// Do NOT add any import

// You may implement add any additional classes you want.
// For example, a Queue class, a Stack class, or a Node class.
// TODO: Here, implement any additional classes you need.
class Stack{
	private  int[] stack;
	private  int s;
	private  int size;
	public Stack(int sz) {
		
		stack=new int[sz];
		s=0;
		
	}
	
	public void push(int a) {
	
		stack[s++]= a; 
		size++;
		
	}
	public int peek() {
		return stack[size-1]; 
		
	}
	public int size() {
		return size; 
		
	}
	public int pop() {
		
		
		return stack[--size];
	}
	public boolean contains(int x) {
		for(int a =0; a<=s; a++) {
			if(stack[a] == x) {
				return true;
			}
		}
		return false;
	}
	
}
class Queue{
	private  int[] queue;
	private  int s;
	private  int a;
	private  int b;
	public Queue(int sz) {
		
		queue=new int[sz];
		
		
	}
	public void add(int sz) {
		queue[s]= sz; 
		++s;
	} 
	public int size() {
		return s;
	}
	public int peak() {
		return queue[b];
	}
	public boolean contains(int x) {
		for(int a =0; a<=s; a++) {
			if(queue[a] == x) {
				return true;
			}
		}
		return false;
	}
	public int poll() {
		
	++b;

		return queue[a++];
	}
	public int added() {

		return queue[s-1];
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(s<1) {
			return true;
		}
		return false;
	}
}
class Vertex{
	 private int up;
	 private int down;
	 private int jump;
	 private int prev;
	    
	    public Vertex(int up, int down, int jump,int prev) {
	        this.up = up;
	        this.down = down;
	        this.jump = jump;
	        this.prev = prev;
	    }
	    
	    public int getUp() {
	        return up;
	    }
	    
	    public void setUp(int up) {  
	        this.up = up;
	    }
	    
	    public int getDown() {
	        return down;
	    }
	    
	    public void setDown(int down) {
	        this.down = down;
	    }
	    public int getJump() {
	        return jump;
	    }
	    
	    public void setJump(int jump) {
	        this.jump = jump;
	    }
	    public int getPrev() {
	        return prev;
	    }
	    
	    public void setPrev(int prev) {
	        this.prev = prev;
	    }
	
}

public class A4Q2 {

    public static int minimumButtonPushes(int N, int U, int D, int X, int Y) {

        // TODO: Implement this method.
    	Queue q= new Queue(10000000);
    	
    	Stack visited = new Stack(1000000);
    	
Vertex[] graph= new Vertex[N+1];
    	
 
int count = 0;
int a = 0;

for (a = 1; a <= N; a++) {

	graph[a] = new Vertex(a + U, a - D, a * 2, 0);
	if (a + U > N) {
		graph[a].setUp(N);
	}
	if (a * 2 > N) {
		graph[a].setJump(N);
	}
	if (a - D < 1) {
		graph[a].setDown(1);
	}

}

a = X;

boolean visited2[] = new boolean[2 * N];

int x = X;

visited2[x] = true;
q.add(X);

while (graph[x] != null) {

	q.add(graph[x].getUp());
	q.add(graph[x].getDown());
	q.add(graph[x].getJump());
	visited.push(x);
	visited2[x] = true;
	x = q.poll();
	while (visited2[x] == true) {
		x = q.poll();
		if (x == 0) {
			return -1;

		}
	}
	if (graph[x].getUp() == Y || graph[x].getDown() == Y || graph[x].getJump() == Y) {
		visited.push(x);
		break;
	}
}
int b = visited.size();
int a1 = Y;
while (visited.size() > 0) {

	b = visited.pop();
	if (graph[b].getUp() == a1 || graph[b].getDown() == a1 || graph[b].getJump() == a1) {
		a1 = b;
		++count;
	}
}

return count;
    }

    public static void main(String[] args) {

        // Below are a few test cases.
        // Printing "true" means the return value is correct.
        // Each call to minimumButtonPushes() must take less than 1 second.

        System.out.println(3 == minimumButtonPushes(10, 2, 1, 1, 10));
        System.out.println(5 == minimumButtonPushes(100, 3, 7, 20, 11));
        System.out.println(90 == minimumButtonPushes(1000, 20, 11, 987, 21));
        System.out.println(19 == minimumButtonPushes(1000000, 2011, 3101, 12, 777777));
        System.out.println(-1 == minimumButtonPushes(20, 21, 3, 1, 19));
    }
}
