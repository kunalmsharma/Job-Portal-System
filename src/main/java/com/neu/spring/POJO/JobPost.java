package com.neu.spring.POJO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="JobPost")
public class JobPost 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="jobpostid")
	private int jobpostid;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="requirement")
	private String requirement;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Manager manager;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="jobpost", cascade=CascadeType.ALL)
	private List<JobApplied> jobappliedList;
	
	public JobPost(){
		
	}

	public int getJobpostid() {
		return jobpostid;
	}

	public void setJobpostid(int jobpostid) {
		this.jobpostid = jobpostid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<JobApplied> getJobappliedList() {
		return jobappliedList;
	}

	public void setJobappliedList(List<JobApplied> jobappliedList) {
		this.jobappliedList = jobappliedList;
	}
	
	
}
