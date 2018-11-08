

public class PriorityQueueSimulatorTester {
	
//Creating the initial array of jobs:
	public static Job[] creatInputJobArray(int k, Job[]arr) {
		for (int i =0; i<k;i++) {
		String jobName = "JOB_"+i+1;
		int r = (int) (Math.random() * (70 - 1)) + 1;
		int jobLength  = r;
		int currentJobLength = r;
		int pr = (int) (Math.random() * (40 - 1)) + 1;
		int jobPriority = pr;
		int finalPriority =pr;
		int entryTime = 0, endTime=0, waitTime =0;
		Job newJob = new Job(jobName,jobLength,currentJobLength,jobPriority,finalPriority,entryTime,endTime,waitTime);
		arr[i]= newJob;
		}
		return arr;
	}
	

	public static void main(String[] args) {
		
//number of Jobs:
		int[] maxNumberOfJobs = {10,100, 1000, 10000, 100000, 1000000};

//It will loop on the maxNumberOfJobs array:
		for (int i =0; i<1;i++) {
			Job[] jobsInputArray  = new Job[maxNumberOfJobs[i]];
			jobsInputArray = creatInputJobArray(maxNumberOfJobs[i],jobsInputArray);
			Array_Heap arrayHeap = new Array_Heap(maxNumberOfJobs[i]);
			for(int j=0; j<jobsInputArray.length;j++) {
				Entry e1 = new Entry<Job,Integer,Integer>(jobsInputArray[j],jobsInputArray[j].getJobFinalPriority(),1);
				arrayHeap.Insert(e1);
			}
			System.out.println(arrayHeap.toString());
		}
	}

}
