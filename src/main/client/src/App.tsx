import './App.css'
import './assets/css/utils.css'
import Prompt from './pages/prompt'
import MainLayout from './layout/main.ayout'
import {BrowserRouter, Routes, Route} from "react-router-dom"
import JoListings from "./pages/JobListings"


function App() {

  return (
    <BrowserRouter>
    <MainLayout>
    <Routes>
      
        <Route path="/prompts" element={<Prompt />} />
        <Route path="/jobListings" element={<JoListings />} />
      
    </Routes>
    </MainLayout>
    </BrowserRouter>
    
  )
}

export default App
