import java.io.*;

public class PriorityQueueSimulatorTester {
	
//Creating the initial array of jobs:
	public static Job[] creatInputJobArray(int k, Job[]arr) {
		for (int i =0; i<k;i++) {
			String jobName       = "JOB_"+i+1;
			int r                = (int) (Math.random() * (70 - 1)) + 1;
			int jobLength        = r;
			int currentJobLength = r;
			int pr               = (int) (Math.random() * (40 - 1)) + 1;
			int jobPriority      = pr;
			int finalPriority    = pr;
			long entryTime       = 0, endTime=0, waitTime =0;
			long age             = 0;
			Job newJob           = new Job(jobName,jobLength,currentJobLength,jobPriority,finalPriority,entryTime,endTime,waitTime,age);
			arr[i]               = newJob;
		}
		return arr;
	}
	

	public static void CpuSimulator_Heap(Array_Heap arrayHeap, int counterAge, int count,int size,PrintWriter pw) {
		long[] waitArr           = new long [size];
		int positionWaitArr      =0;
		int numOfPriorityChanges =0;
		while (!arrayHeap.isEmpty()) {
			int k =0;
			while(k!=30) {
				count      = count +1;
				Entry <Job,Integer,Integer> e1 =arrayHeap.removeMin();
				System.out.println("Now executing "+ ((Job) e1.value).jobName +". Job length: "+ ((Job) e1.value).jobLength +
						" cycles; Current remaing length: "+ ((Job) e1.value).jobCurrentLength +" cycles; Initial priority: "+ ((Job) e1.value).jobPriority +";"+
						" Current priority: "+ ((Job) e1.value).jobFinalPriority);
				((Job) e1.value).jobCurrentLength =((Job) e1.value).jobCurrentLength -1;
				if(((Job) e1.value).jobCurrentLength ==0){
					k++;
					Long waitTime = count - ((Job) e1.value).jobLength - ((Job) e1.value).entryTime ;
					waitArr[positionWaitArr]= waitTime;
					if(arrayHeap.isEmpty()) {
						break;
					}
				}
				else {
					counterAge = counterAge+1;
					e1.key2 = counterAge;
					((Job) e1.value).age =((Job) e1.value).age +1;
					arrayHeap.Insert(e1);
					k++;
				}
			}
			numOfPriorityChanges += Starvation(arrayHeap,size,numOfPriorityChanges);
			count = count+1;
		}	
			long AverageWaitingTime = CalculateAverage(waitArr);
				
//Printing out:
		pw.println("Array-List Heap:");
		pw.println("Current system time (cycles): " + count);
		pw.println("Total number of jobs executed: " + size);
		pw.println("Average process waiting time: "+ AverageWaitingTime);
		pw.println("Total number of priority chnages: "+ numOfPriorityChanges);
		pw.println("Actual system time needed to execute all hobs: ");
	}
	
//Starvation method for the Array_Heap:
	public static int Starvation(Array_Heap arrayHeap, int size, int numOfPriorityChanges) {
		Entry poorJob = new Entry<Job,Integer,Integer>();
		      poorJob = arrayHeap.arr[0];
		      int counter=1;
		for (int i =1; i<size; i++) {
			if(arrayHeap.arr[i]!=null) {
				if((arrayHeap.arr[i].key1.compareTo(poorJob.key1))==1) {
					poorJob = arrayHeap.arr[i];
					counter=i;
				}
			}
		}
		if(poorJob !=null && counter <= arrayHeap.getRightMost() ) {
			((Job) poorJob.value).jobFinalPriority = 1;
			poorJob.key1 =1;
			numOfPriorityChanges =numOfPriorityChanges +1;
			arrayHeap.upHeap(counter);
		}
		return 1;
	}
//Calculating average Wait Time
	public static long CalculateAverage(long[] waitTime) {
		long AverageWaitingTime=0;
		for (int i =0; i<waitTime.length;i++) {
			AverageWaitingTime += (long)waitTime[i];
		}
		AverageWaitingTime = AverageWaitingTime/(long)(waitTime.length);
		return AverageWaitingTime;
	}
	

	public static void main(String[] args) {
		PrintWriter pw= null;
        try{	
        pw = new PrintWriter(new FileOutputStream("SimulatorPerformanceResults.txt"));
        }
        catch (FileNotFoundException e){
        System.out.println(e.getStackTrace());
        } 
		
//number of Jobs:
		int[] maxNumberOfJobs = {10,100, 1000, 10000, 100000, 1000000};
		int counterAge=0;
		int count=0;
//It will loop on the maxNumberOfJobs array:
		for (int i =0; i<1;i++) {
			
			Job[] jobsInputArray  = new Job[maxNumberOfJobs[i]];
			jobsInputArray = creatInputJobArray(maxNumberOfJobs[i],jobsInputArray);
			Array_Heap arrayHeap = new Array_Heap(maxNumberOfJobs[i]);
			for(int j=0; j<jobsInputArray.length;j++) {
				counterAge++;
				count++;
				Entry e1 = new Entry<Job,Integer,Integer>(jobsInputArray[j],jobsInputArray[j].jobFinalPriority,counterAge);
				((Job) e1.value).age=counterAge;
				((Job) e1.value).entryTime=counterAge;
				arrayHeap.Insert(e1);	
			}
			arrayHeap.toString();
			CpuSimulator_Heap(arrayHeap,counterAge,count,maxNumberOfJobs[i],pw);
			jobsInputArray =null;
		}
		pw.close();
	}

}
