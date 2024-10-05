import JobStatus from "../../../enums/JobStatus";
import JobType  from "../../../enums/JobType";
import WorkSetting from "../../../enums/WorkSetting";
  
type JobListing = {
    jobTitle: string;
    jobDescription: string;
    jobType: JobType;
    datePosted: string; 
    workSetting: WorkSetting;
    status: JobStatus;
    source: string;
    urgent: boolean;
};

export default JobListing
