import { useState } from "react"
import JobListing from "../types/JobListing"
import JobType from "../../../enums/JobType"
import JobStatus from "../../../enums/JobStatus"
import WorkSetting from "../../../enums/WorkSetting"
import { JOB_SOURCE } from "../../../constants/jobSource"

function useJobListing() {

const [jobListing, setJoblisting] = useState<JobListing>({
    jobTitle: "",
    jobDescription: "",
    jobType: JobType.FULL_TIME,
    datePosted: "",
    workSetting: WorkSetting.ON_SITE,
    status: JobStatus.APPLIED,
    source: JOB_SOURCE[0],
    urgent: false,
    })

    const setJobTitle = (jobTitle: string) : void => {
        setJoblisting((prevState) => ({...prevState, jobTitle}))
      }

      const setJobDescription = (jobDescription: string) : void => {
        setJoblisting((prevState) => ({...prevState, jobDescription}))
      }

      const setJobType = (jobType: JobType) : void => {
        setJoblisting((prevState) => ({...prevState, jobType}))
      }

      const setdatePosted = (datePosted: string) : void => {
        setJoblisting((prevState) => ({...prevState, datePosted}))
      }

      const setWorkSetting = (workSetting: WorkSetting) : void => {
        setJoblisting((prevState) => ({...prevState, workSetting}))
      }

      const setStatus = (status: JobStatus) : void => {
        setJoblisting((prevState) => ({...prevState, status}))
      }

      const setSource = (source: string) : void => {
        setJoblisting((prevState) => ({...prevState, source}))
      }

      const setUrgent = (urgent: boolean) : void => {
        setJoblisting((prevState) => ({...prevState, urgent}))
      }

  return (
    {
        jobListing,
        setJobTitle,
        setJobDescription,
        setJobType,
        setdatePosted,
        setWorkSetting,
        setStatus,
        setSource,
        setUrgent

    }
  )
}

export default useJobListing