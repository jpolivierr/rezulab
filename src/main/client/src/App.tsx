import { ChangeEvent, useState } from 'react'
import './App.css'
import './assets/css/utils.css'

function App() {

  const [promptText, setPromptText] = useState<string>("")
  const [requirementText, setRequirementText] = useState<string>("")
  const promptDetails = {
    experienceId: [1,2],
    resumeTemplateId: 2,
    promptId: 1
  }

  const makeRequest = async () => {

    try {
      const config = {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(promptDetails)
      }

      const response = await fetch("http://localhost:8080/generate_prompt?email=jp@gmail.com", config)

      if (!response.ok) {
        throw new Error('Network response was not ok');
      }

      const jsonData = await response.json();
      console.log('Success:', jsonData); // Handle the response data
      setPromptText(jsonData.data)
      return jsonData; 

    } catch (error) {
      console.error('Error:', error); 
    }

    
    
  }

  const generatePrompt = () => {
    makeRequest()
  }

  const handleRequirementTextChange = (event: ChangeEvent<HTMLTextAreaElement>) => {
    setRequirementText(event.target.value);
  };

  const handlepromptTextChange = (event: ChangeEvent<HTMLTextAreaElement>) => {
    setPromptText(event.target.value);
  };

  return (
    <main className='theme-dark bk'>
      <div className='container'>
        <div className='prompt-component layout'>
          <header className='padding lbk border border-radius c-1'>
            <div className='button-container'>
              <button onClick = {() => generatePrompt()} className='button main-btn'>
                Generate Prompt
              </button>
            </div>
          </header>

            <div className='job-requirements border-radius lbk border padding w-1'>
              <h3>Job Requirements</h3>
              <div>
                  <textarea 
                  value={requirementText} 
                  className='border lrbk'
                  onChange={handleRequirementTextChange}
                  >

                </textarea>
              </div>
              
            </div>

            <div className='job-requirements border-radius lbk border padding w-1'>
              <h3>Prompt</h3>
              <div className='over-flow-hidden'>
                <textarea 
                value={promptText} 
                className='border lrbk'
                onChange={handlepromptTextChange}
                >
              </textarea>
              </div>
              
            </div>
        </div>
       
       
      </div>
    </main>
  )
}

export default App
