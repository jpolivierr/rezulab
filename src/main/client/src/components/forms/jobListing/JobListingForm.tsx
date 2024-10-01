import { useState } from "react";
import { JobListing, JobType, WorkSetting, JobStatus } from "../../../types/JobListing";
import DropDown from "../../dropDown/DropDown";
import { capFirstLetter } from "../../../utils/TextFormat";

function JobListingForm() {

      const sourceOption = {
        Indeed: "Indeed",
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

      const isSelectedType = (jobType: JobType): boolean => {
        return jobType === jobListing.jobType
      }

      const isSelectedWorkSetting= (workSetting: WorkSetting): boolean => {
        return workSetting === jobListing.workSetting
      }

  const submit = (e:any) => {
    e.preventDefault()
  }    

  const [formStep, setFormStep] = useState({
    currentStep: 1,
    totalStep: 2
  })

  const next = () => {
    if(formStep.currentStep < formStep.totalStep){
      setFormStep((prevState) => ({...prevState, currentStep: formStep.currentStep ++}))
    }
  }

  const prev = () => {
    if(formStep.currentStep > 1){
      setFormStep((prevState) => ({...prevState, currentStep: formStep.currentStep --}))
    }
  }

  const isFirstStep = () => {
    return formStep.currentStep === 1
  }

  const isLastStep = () => {
    return formStep.currentStep === formStep.totalStep
  }


  const showCurrentStep = (step: number) => {
    if(step === formStep.currentStep){
      return "show"
    }

    return "hide"
  }

  return (
    <form className="main-form" onSubmit={submit}>
        <fieldset className={`${showCurrentStep(1)}`}>
            <legend>Company</legend>
            <section>
                <label>Company Name</label>
                <input type="text"/>
            </section>
            <section>
                <label>About</label>
                <textarea 
                    value={jobListing.jobTitle} 
                    className='border lrbk'
                    // onChange={(e) => setJobTitle(e.target.value)}
                    ></textarea>
            </section>
        </fieldset>

        <fieldset className={`${showCurrentStep(2)}`}>
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
                <textarea 
                    value={jobListing.jobTitle} 
                    className='border lrbk'
                    onChange={(e) => setJobTitle(e.target.value)}
                    ></textarea>
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
                  <li onClick={() => setSource(sourceOption.Indeed)}>{capFirstLetter(sourceOption.Indeed)}</li>
                    <li onClick={() => setSource(sourceOption.linkedIn)}>{capFirstLetter(sourceOption.linkedIn)}</li>
                    <li onClick={() => setSource(sourceOption.zipRecruiter)}>{capFirstLetter(sourceOption.zipRecruiter)}</li>
                    <li onClick={() => setSource(sourceOption.companySite)}>{capFirstLetter(sourceOption.companySite)}</li>
                  </ul>
                </DropDown>
            </section>

            <section>
                <label>Job Type</label>
                <div className="select-options">
                  <button onClick={() => setJobType(JobType.FULL_TIME)}
                          className={`border ${isSelectedType(JobType.FULL_TIME) ? 'selected-option' : ""}`}>
                            {isSelectedType(JobType.FULL_TIME) ? <i className="fa-solid fa-check"></i> : null}
                            {capFirstLetter(JobType.FULL_TIME)}
                  </button>

                  <button onClick={() => setJobType(JobType.PART_TIME)}
                           className={`border ${isSelectedType(JobType.PART_TIME) ? 'selected-option' : ""}`}>
                            {isSelectedType(JobType.PART_TIME) ? <i className="fa-solid fa-check"></i> : null}
                            {capFirstLetter(JobType.PART_TIME)}
                  </button>
                  <button onClick={() => setJobType(JobType.CONTRACT)}
                          className={`border ${isSelectedType(JobType.CONTRACT) ? 'selected-option' : ""}`}>
                            {isSelectedType(JobType.CONTRACT) ? <i className="fa-solid fa-check"></i> : null}
                            {capFirstLetter(JobType.CONTRACT)}
                  </button>
                </div>
            </section>

            <section>
                <label>Work Setting</label>
                <div className="select-options">

                  <button onClick={() => setWorkSetting(WorkSetting.ON_SITE)}
                          className={`border ${isSelectedWorkSetting(WorkSetting.ON_SITE) ? 'selected-option' : ""}`}>
                            {isSelectedWorkSetting(WorkSetting.ON_SITE) ? <i className="fa-solid fa-check"></i> : null}
                            {capFirstLetter(WorkSetting.ON_SITE)}
                  </button>

                  <button onClick={() => setWorkSetting(WorkSetting.REMOTE)}
                           className={`border ${isSelectedWorkSetting(WorkSetting.REMOTE) ? 'selected-option' : ""}`}>
                            {isSelectedWorkSetting(WorkSetting.REMOTE) ? <i className="fa-solid fa-check"></i> : null}
                            {capFirstLetter(WorkSetting.REMOTE)}
                  </button>
                  <button onClick={() => setWorkSetting(WorkSetting.HYBRID)}
                          className={`border ${isSelectedWorkSetting(WorkSetting.HYBRID) ? 'selected-option' : ""}`}>
                            {isSelectedWorkSetting(WorkSetting.HYBRID) ? <i className="fa-solid fa-check"></i> : null}
                            {capFirstLetter(WorkSetting.HYBRID)}
                  </button>
                </div>
            </section>

            <section>
                <label>Status</label>
                <DropDown value={jobTypeDropDown} arrow={true} Class="d-dropdown">
                  <button className="border">{capFirstLetter(jobListing.status)}</button>
                  <ul className="d-window border">
                  <li onClick={() => setStatus(JobStatus.STARTED)}>{capFirstLetter(JobStatus.STARTED)}</li>
                  <li onClick={() => setStatus(JobStatus.PAUSE)}>{capFirstLetter(JobStatus.PAUSE)}</li>
                    <li onClick={() => setStatus(JobStatus.APPLIED)}>{capFirstLetter(JobStatus.APPLIED)}</li>
                    <li onClick={() => setStatus(JobStatus.INTERVIEW)}>{capFirstLetter(JobStatus.INTERVIEW)}</li>
                    <li onClick={() => setStatus(JobStatus.OFFER)}>{capFirstLetter(JobStatus.OFFER)}</li>
                  </ul>
                </DropDown>
            </section>

        </fieldset>

        <div>
            {isFirstStep() ? null : <button onClick={prev} className="button ">Back</button>}
            {isLastStep() ? null : <button onClick={next} className="button main-btn">Next</button>}
            {isLastStep() ? <button className="button main-btn">Submit</button> : null}
        </div>

    </form>
  )
}

export default JobListingForm