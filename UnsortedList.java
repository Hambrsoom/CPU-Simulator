public class UnsortedList{

	private int front;
	private int rear;
	private int currentSize;
	private int maxSize;
	private Entry[] circularQueue;

	//Constructors
	public UnsortedList(){
		front = -1;
		rear = -1;
		currentSize = 0;
		maxSize = 0;
		circularQueue =  new Entry[this.maxSize];
	}

	public UnsortedList(Entry[] circularQueue ,int maxSize){
		front = -1;
		rear = -1;
		currentSize = 0;
		this.maxSize = maxSize;
		this.circularQueue =  new Entry[this.maxSize];		
	}

	//Get & Set
    public int getFront() { return front; }
    public void setFront(int front) {this.front = front;}
    public int getRear() { return rear; }
    public void setRear(int rear) {this.rear = rear; }
    public int getCurrentSize() {return currentSize;}
    public void setCurrentSize(int currentSize) {this.currentSize = currentSize; }
	 public int getMaxSize() { return maxSize;}
	 public void setMaxSize(int maxSize) { this.maxSize = maxSize;}

	//Queue operations
	public int size(){
		return currentSize;
	}

	public boolean isEmpty(){
		return (currentSize==0);
	}
	
	public void insert(Entry object){
		if(size() == maxSize)
			System.out.println("Cannot enqueue  since the Queue is full!");			
		else{	
			rear = (rear + 1) % maxSize;
			circularQueue[rear] = object;
			currentSize++;
			if(front == -1)
				front = rear;
		}
	}

	public void removeMin(){
		if(isEmpty())
			System.out.println("Cannot dequeue since the Queue is empty!");			
		else{
			circularQueue[front] = null;
			front = (front + 1) % maxSize;
			currentSize--;
		}
		
	}

	public String toString() {
		String line = "[";
		for (int i =front;i<maxSize;i++) {
			if(circularQueue[i] == null)
				line = line + "null ";
			else
				line += circularQueue[i].getValue() + " ";
	
		}
		return line+"]";
	}
	public int searchMin () {
		int minimumElementPosition =0;
		for (int i=0; i<maxSize; i++) {
			if((i+1)<= maxSize) {
			if(circularQueue[i]!=null && (circularQueue[i].compareTo(circularQueue[i+1])==1)) {
				minimumElementPosition = i;
			}
			}
		}
		return minimumElementPosition;
	}

	public static void main(String[] args){
		Entry[] arr = new Entry[7];
		UnsortedList queue =  new UnsortedList(arr, 7);
		Entry e1 = new Entry <String,Integer,Integer>("key7key4",7,4);
		Entry e2 = new Entry <String,Integer,Integer>("key5",5,9);
		Entry e3 = new Entry <String,Integer,Integer>("key9",9,122);
		Entry e4 = new Entry <String,Integer,Integer>("key12",12,122);
		Entry e5 = new Entry <String,Integer,Integer>("key1",1,122);
		Entry e6 = new Entry <String,Integer,Integer>("key7key122",7,122);
		Entry e7 = new Entry <String,Integer,Integer>("key2",2,122);
		queue.insert(e1);
		queue.insert(e2);
		queue.insert(e3);	
		queue.insert(e4);	
		queue.insert(e5);	
		queue.insert(e6);
		queue.insert(e7);	
		queue.removeMin();
		queue.removeMin();
		queue.removeMin();
		queue.removeMin();
		queue.insert(e5);
		System.out.println(queue.toString());

	}

}