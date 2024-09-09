import { ChangeEvent, useState } from 'react'

export default function Prompt() {

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
              <header className='padding lrbk border border-radius c-1'>
                <div className='button-container'>
                  <button onClick = {() => generatePrompt()} className='button main-btn'>
                    Generate Prompt
                  </button>
                </div>
              </header>
    
                <div className='text-card border-radius w-1'>
                  <h3>Job Requirements</h3>
                  <div className='textarea-container'>
                    <div className='textarea-header lrbk border padding'>
                        <button className='item'><i className="fa-regular fa-copy"></i> Copy</button>
                    </div>
                      <textarea 
                      value={requirementText} 
                      className='border dbk'
                      onChange={handleRequirementTextChange}
                      >
    
                    </textarea>
                  </div>
                  
                </div>
    
                <div className='text-card border-radius w-1'>
                  <h3>Prompt</h3>
                  <div className='textarea-container'>
                    <div className='textarea-header lrbk border padding'>
                        <button className='item'><i className="fa-regular fa-copy"></i> Copy</button>
                    </div>
                    
                    <textarea 
                    value={promptText} 
                    className='border dbk'
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
