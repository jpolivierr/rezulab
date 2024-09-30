import { useState } from "react";
import { JobListing, JobType, WorkSetting, JobStatus } from "../../../types/JobListing";
import DropDown from "../../dropDown/DropDown";
import { capFirstLetter } from "../../../utils/TextFormat";

function JobListingForm() {

      const sourceOption = {
        linkedIn: "LinkedIn",
        zipRecruiter: "ZipRecruiter",
        companySite: "Company Site"
      }

      const [jobListing, setJoblisting] = useState<JobListing>({
        jobTitle: "",
        jobDescription: "",
        jobType: JobType.FULL_TIME,
        datePosted: "",
        workSetting: WorkSetting.ON_SITE,
        status: JobStatus.APPLIED,
        source: sourceOption.linkedIn,
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

      const [company, setCompany] = useState<Object>({
        name: "",
        about: "",
        address: {
          street: "",
          city: "",
          state: "",
          zipCode: "",
        },
        contactNumbers: [
          {
            type: "mobile",
            ext: "",
            number: "",
          },
        ],
      })

      const [payRange, setPayRange] = useState<Object>({
        min: 0,
        max: 0,
        period: "yearly",
      })

      const [jobTypeDropDown, setJobTypeDropDown] = useState<boolean>(false)

  return (
    <form className="main-form">
        <fieldset>
            <legend>Company</legend>
            <section>
                <label>Company Name</label>
                <input type="text"/>
            </section>
            <section>
                <label>About</label>
                <input type="text"/>
            </section>
        </fieldset>

        <fieldset>
            <legend>Job Post</legend>
            <section>
                <label>Job Title</label>
                <input type="text"
                       value={jobListing.jobTitle} 
                       onChange={(e) => setJobTitle(e.target.value)}
                      />
            </section>
            <section>
                <label>Job Description</label>
                <input type="text"
                       value={jobListing.jobTitle} 
                       onChange={(e) => setJobTitle(e.target.value)}
                      />
            </section>
            <section>
                <label>Source</label>
                <DropDown value={jobTypeDropDown} arrow={false} Class="d-dropdown">
                  <div>
                    <input style={{cursor: "pointer"}} 
                           type="text" 
                           value={capFirstLetter(jobListing.source)}
                           onChange={(e) => setSource(capFirstLetter(e.target.value))}
                           />
                  </div>
                  <ul className="d-window border">
                    <li onClick={() => setSource(sourceOption.linkedIn)}>{capFirstLetter(sourceOption.linkedIn)}</li>
                    <li onClick={() => setSource(sourceOption.zipRecruiter)}>{capFirstLetter(sourceOption.zipRecruiter)}</li>
                    <li onClick={() => setSource(sourceOption.companySite)}>{capFirstLetter(sourceOption.companySite)}</li>
                  </ul>
                </DropDown>
            </section>
            <section>
                <label>Job Type</label>
                <DropDown value={jobTypeDropDown} arrow={true} Class="d-dropdown">
                  <button className="border">{capFirstLetter(jobListing.jobType)}</button>
                  <ul className="d-window border">
                    <li onClick={() => setJobType(JobType.FULL_TIME)}>{capFirstLetter(JobType.FULL_TIME)}</li>
                    <li onClick={() => setJobType(JobType.PART_TIME)}>{capFirstLetter(JobType.PART_TIME)}</li>
                    <li onClick={() => setJobType(JobType.CONTRACT)}>{capFirstLetter(JobType.CONTRACT)}</li>
                  </ul>
                </DropDown>
            </section>

            <section>
                <label>Status</label>
                <DropDown value={jobTypeDropDown} arrow={true} Class="d-dropdown">
                  <button className="border">{capFirstLetter(jobListing.status)}</button>
                  <ul className="d-window border">
                    <li onClick={() => setStatus(JobStatus.APPLIED)}>{capFirstLetter(JobStatus.APPLIED)}</li>
                    <li onClick={() => setStatus(JobStatus.INTERVIEW)}>{capFirstLetter(JobStatus.INTERVIEW)}</li>
                    <li onClick={() => setStatus(JobStatus.OFFER)}>{capFirstLetter(JobStatus.OFFER)}</li>
                  </ul>
                </DropDown>
            </section>

            <section>
                <label>Work Setting</label>
                <DropDown value={jobTypeDropDown} arrow={true} Class="d-dropdown">
                  <button className="border">{capFirstLetter(jobListing.workSetting)}</button>
                  <ul className="d-window border">
                    <li onClick={() => setWorkSetting(WorkSetting.ON_SITE)}>{capFirstLetter(WorkSetting.ON_SITE)}</li>
                    <li onClick={() => setWorkSetting(WorkSetting.REMOTE)}>{capFirstLetter(WorkSetting.REMOTE)}</li>
                    <li onClick={() => setWorkSetting(WorkSetting.HYBRID)}>{capFirstLetter(WorkSetting.HYBRID)}</li>
                  </ul>
                </DropDown>
            </section>
        </fieldset>

    </form>
  )
}

export default JobListingForm