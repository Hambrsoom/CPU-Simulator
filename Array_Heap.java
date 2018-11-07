
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
		this.arr         = new Entry[size];
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
	public void upHeap(int k) {
		while (k != 1) {
			if (heap[k / 2].getJobPriority() > heap[k].getJobPriority()) {
				swap(k, k / 2);
			}
			k = k - 1;
		}
	}
	public void upHeap(int i) {
		if(arr[i/2].compareTo(arr[])==1 && arr[i].compareTo(arr[2*i+2])==1)
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
			if(arr[2*i+1].compareTo(arr[2*i+2])==1 && arr[i].compareTo(arr[2*i+2])==1) {
				arr[i].Swap(arr[i],arr[2*i+2]);
				bottomDown(2*i+2);
			}
			else if(arr[2*i+1].compareTo(arr[2*i+2])==-1 &&arr[i].compareTo(arr[2*i+1])==1) {
				arr[i].Swap(arr[i], arr[2*i+1]);
				bottomDown(2*i+1);
			}
			else {
				System.out.println("Sorted");
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
	public String toString() {
		String line = "";
		for (int i =0;i<arr.length;i++) {
			if(arr[i]!=null) {
				line += arr[i].value+ " ";
			}
		}
		return line;
	}
	

	public static void main(String[] args) {
		Entry[]arr = new Entry[10];
		Array_Heap kok = new Array_Heap(arr,10);
		Entry e1 = new Entry <String,Integer,Integer>();
		e1.key1=2;
		e1.key2=2;
		e1.value="poato";
		Entry e2 = new Entry <String,Integer,Integer>("mo",3,4);
		kok.Insert(e1);
		kok.Insert(e2);
		Entry e3 = new Entry <String,Integer,Integer>("mo",10,4);
		Entry e4 = new Entry <String,Integer,Integer>("me",3,9);
		Entry e5 = new Entry <String,Integer,Integer>("uou",2,3);
		Entry e6 = new Entry <String,Integer,Integer>("karen",1,2);
		Entry e7 = new Entry <String,Integer,Integer>("sad",12,4);
		Entry e8 = new Entry <String,Integer,Integer>("koko",5,122);
		Entry e9 = new Entry <String,Integer,Integer>("haoh",5,4);
		Entry e10 = new Entry <String,Integer,Integer>("asddasd",5,3);
		kok.Insert(e3);
		kok.Insert(e4);
		kok.Insert(e5);
		kok.Insert(e6);
		kok.Insert(e7);
		kok.Insert(e8);
		kok.Insert(e9);
		
		System.out.println("f: " + kok.isEmpty());
		System.out.println("toString: "+ kok.toString());	}

}
