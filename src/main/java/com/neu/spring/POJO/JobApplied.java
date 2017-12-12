package com.neu.spring.POJO;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class JobApplied {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="jobappliedid")
	private int jobappliedid;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private JobSeeker jobseeker;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private JobPost jobpost;	
	
	JobApplied(){
		
	}

	public int getJobappliedid() {
		return jobappliedid;
	}

	public void setJobappliedid(int jobappliedid) {
		this.jobappliedid = jobappliedid;
	}

	public JobSeeker getJobseeker() {
		return jobseeker;
	}

	public void setJobseeker(JobSeeker jobseeker) {
		this.jobseeker = jobseeker;
	}

	public JobPost getJobpost() {
		return jobpost;
	}

	public void setJobpost(JobPost jobpost) {
		this.jobpost = jobpost;
	}

	
	
}
