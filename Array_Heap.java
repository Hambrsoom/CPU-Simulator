
public class Array_Heap {
	
//Attributes	
	public Entry[] arr ;
	private int size;
	private int rightMost = -1;
	
//Constructors
	public Array_Heap() {
		arr         = (Entry[]) new Object[size];
		size        = 0;
 		rightMost   = -1;
	}
	public Array_Heap(Entry[]arr,int size) {
		this.rightMost   = -1;
		this.size        = size;
		this.arr         = (Entry[]) new Object [size];
	}
//An inner class for what we will be storing in the array
	
//Setters and Getters
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getRightMost() {
		return rightMost;
	}
	public void setRightMost(int rightMost) {
		this.rightMost = rightMost;
	}
	
//It will insert at the rightMost then heapify it
	public void Insert(Entry newNode) {
//do you want to make it bigger ?
		if(rightMost >= arr.length-1) {
			System.out.println("A full array");
		}
		else 
			rightMost = rightMost+1;
			arr[rightMost] = newNode;
//dont forget to sort it Up-Heap
	}
	
//Sorting the heap (putting the min on the top)
	
	public void removeMin() {
		if(this.isEmpty()) {
			System.out.println("The heap is empty");
		}
		else if (rightMost >= this.getSize()-1) {
			System.out.println("The heap is full");
		}
		else {
			arr[0]         = null;
			arr[0]         = arr[rightMost];
			arr[rightMost] = null;
			rightMost      = rightMost-1;
		}
	}
	
//Bottom-down the heap after executing removeMin():
	public void bottomDown(int i) {
		if(i >= (getSize()-1)/2) {
			System.out.println("The heap is Sorted");
		}
		else {
			if((arr[2*i+1].key1).compareTo(arr[2*i+2].key1)) {
				System.out.println("mom");
			}
		}
	}

//will verify if the heap is empty
	public boolean isEmpty() {
		if(arr[0]==null) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		
	}

}
