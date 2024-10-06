import { useState } from "react";
import DropDown from "../../dropDown/DropDown";
import { capFirstLetter } from "../../../utils/TextFormat";
import JobType from "../../../enums/JobType";
import WorkSetting from "../../../enums/WorkSetting";
import JobStatus from "../../../enums/JobStatus";
import useCompany from "../../../domain/company/hooks/useCompany";
import useJobListing from "../../../domain/jobListing/hooks/useJobListing";
import { JOB_SOURCE } from "../../../constants/jobSource";
import { PHONE_TYPE } from "../../../constants/PhoneType";
import ValueOptions from "../../valueOptions/ValueOptions";

function JobListingForm() {

      const {
        maxNumCount,
        company,
        setName,
        setAbout, 
        setNumberExt,
        setNumber,
        setNumberType,
        addContactNumber,
        removeContactNumber,
        setStreet,
        getStreet,
        setCity,
        getCity,
        setState,
        getState,
        setZipCode,
        getZipCode,
        removeAddress
      } = useCompany()

      const {
        jobListing,
        setJobTitle,
        setJobDescription,
        setJobType,
        setdatePosted,
        setWorkSetting,
        setStatus,
        setSource,
        setUrgent 
      } = useJobListing()
      

      const [payRange, setPayRange] = useState<Object>({
        min: 0,
        max: 0,
        period: "yearly",
      })

      const [jobTypeDropDown] = useState<boolean>(false)

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

  const [showAddress, setShowAddress] = useState(false)

  const toggleAddress = () => {

    if(showAddress){
      removeAddress()
      setShowAddress(false)
    }else {
      setShowAddress(true)
    }

  }

  const next = () => {
    if(formStep.currentStep < formStep.totalStep){
      setFormStep((prevState) => ({...prevState, currentStep: formStep.currentStep + 1}))
    }
  }

  const prev = () => {
    if(formStep.currentStep > 1){
      setFormStep((prevState) => ({...prevState, currentStep: formStep.currentStep - 1}))
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

  console.log(company)

  return (
    <form className="main-form" onSubmit={submit}>
        <fieldset className={`${showCurrentStep(1)}`}>
            <legend>Company</legend>
            <section>
                <label>Company Name</label>
                <input type="text"
                       value={company.name} 
                       onChange={(e) => setName(e.target.value)}
                      />
            </section>
            <section>
                <label>About</label>
                <textarea 
                    value={company.about} 
                    className='border lrbk'
                    onChange={(e) => setAbout(e.target.value)}
                    ></textarea>
            </section>
          <section>
            <label>Contact Numbers</label>
            <ValueOptions 
                  isMax={maxNumCount} 
                  label="Add Number" 
                  buttonStyle="button alt-btn"
                  removeIcon={true}
                  add={addContactNumber}
                  remove={removeContactNumber}
                  >
                  {
                        company.contactNumbers.map((numbers, index) => (
                          <div key={index} className="number-option-block">

                            <DropDown value={jobTypeDropDown} arrow={true} Class="d-dropdown">
                              <button className="border">Mobile</button>
                              <ul className="d-window border">
                                {PHONE_TYPE.map( (type,index) => (
                                  <li key={index} onClick={() => setNumberType(index, type)}>{capFirstLetter(type)}</li>
                                ))}
                              </ul>
                            </DropDown>
                                  
                            <input type="text" 
                                  placeholder="Phone number" 
                                  onChange={(e) => {setNumber(index, e.target.value)}}/>

                            <div>
                            <label>Ext.</label>
                            <input  type="text" 
                                    placeholder="948" 
                                    value={numbers.ext} onChange={(e) =>{setNumberExt(index, e.target.value)}}
                                    />
                            </div>  
                            
                          </div>
                        ))
                      }
            </ValueOptions>
          </section>
          <section>
            <label>Location</label>
            <ValueOptions 
                  isMax={showAddress} 
                  label="Add Location" 
                  buttonStyle="button alt-btn"
                  removeIcon={true}
                  add={toggleAddress}
                  remove={toggleAddress}
                  >
                  {
                  showAddress && 
                  <div>
                    <div>
                      <label>Street</label>
                      <input type="text" value={getStreet()} onChange={(e) => setStreet(e.target.value)}/>
                    </div>
                    <div>
                      <label>city</label>
                      <input type="text" value={getCity()} onChange={(e) => setCity(e.target.value)}/>
                    </div>
                    <div>
                      <label>State</label>
                      <input type="text" value={getState()} onChange={(e) => setState(e.target.value)}/>
                    </div>
                    <div>
                      <label>Zipcode</label>
                      <input type="text" value={getZipCode()} onChange={(e) => setZipCode(e.target.value)}/>
                    </div>
                  </div>
                  }  
                  
            </ValueOptions>
          </section>
        </fieldset>

        <fieldset className={`${showCurrentStep(2)}`}>
            <legend>Job Post</legend>
            <section>
                <label>Job Title</label>
                <input 
                    type="text"
                    value={jobListing.jobTitle} 
                    onChange={(e) => setJobTitle(e.target.value)}
                      />
            </section>
            <section>
                <label>Job Description</label>
                <textarea 
                    value={jobListing.jobDescription} 
                    className='border lrbk'
                    onChange={(e) => setJobDescription(e.target.value)}
                    ></textarea>
            </section>
            <section>
                <label>Source</label>
                <DropDown value={false} arrow={false} Class="d-dropdown">
                  <div>
                    <input style={{cursor: "pointer"}} 
                           type="text" 
                           value={capFirstLetter(jobListing.source)}
                           onChange={(e) => setSource(capFirstLetter(e.target.value))}
                           />
                  </div>
                  <ul className="d-window border">
                    {
                      JOB_SOURCE.map( (source, index) => (
                          <li key={index} onClick={() => setSource(source)}>{capFirstLetter(source)}</li>
                      ))
                    }
                  
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