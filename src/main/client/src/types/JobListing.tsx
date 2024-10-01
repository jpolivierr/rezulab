export enum JobType {
    FULL_TIME = "full-time",
    PART_TIME = "part-time",
    CONTRACT = "contract",
  }
  
  export enum WorkSetting {
    REMOTE = "remote",
    ON_SITE = "on-site",
    HYBRID = "hybrid",
  }
  
  export enum JobStatus {
    STARTED = "started",
    PAUSE = "pause",
    APPLIED = "applied",
    INTERVIEW = "interview",
    OFFER = "offer",
    REJECTED = "rejected",
  }

export type JobListing = {
    jobTitle: string;
    jobDescription: string;
    jobType: JobType;
    datePosted: string; 
    workSetting: WorkSetting;
    status: JobStatus;
    source: string;
    urgent: boolean;
  };