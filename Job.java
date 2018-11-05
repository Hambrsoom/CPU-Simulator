
public class Job {
	
//Attributes:
	private String  jobName;
	private int     jobLength;
	private int     jobCurrentLength;
	private int     jobPriority;
	private int     jobFinalPriority;
	private long    EntryTime;
	private long    EndTime;
	
//Setters and Getters:
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getJobLength() {
		return jobLength;
	}

	public void setJobLength(int jobLength) {
		this.jobLength = jobLength;
	}

	public int getJobCurrentLength() {
		return jobCurrentLength;
	}

	public void setJobCurrentLength(int jobCurrentLength) {
		this.jobCurrentLength = jobCurrentLength;
	}

	public int getJobPriority() {
		return jobPriority;
	}

	public void setJobPriority(int jobPriority) {
		this.jobPriority = jobPriority;
	}

	public int getJobFinalPriority() {
		return jobFinalPriority;
	}

	public void setJobFinalPriority(int jobFinalPriority) {
		this.jobFinalPriority = jobFinalPriority;
	}

	public long getEntryTime() {
		return EntryTime;
	}

	public void setEntryTime(long entryTime) {
		EntryTime = entryTime;
	}

	public long getEndTime() {
		return EndTime;
	}

	public void setEndTime(long endTime) {
		EndTime = endTime;
	}
	
//main method:
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
