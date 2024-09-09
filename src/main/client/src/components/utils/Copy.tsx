import { FC, ReactNode, useState } from 'react'

interface CopyProps {
    text: string;
    children: ReactNode;
  }

  const Copy: FC<CopyProps> = ({ text, children }) => {

    const [floatingStyle, setFloatingStyle] = useState<string>("")

    const copyHandler = async () => {
      try {
        await navigator.clipboard.writeText(text); // Copy text to the clipboard
        setFloatingStyle("float-up")
        setTimeout(() => {
          setFloatingStyle("")
        }, 700)
      } catch (err) {
        console.error('Failed to copy text:', err);
      }
    }

    return (
        <span className='copyt-text-button' onClick={() => copyHandler()}>
          <div className={`copy-message ${floatingStyle}`}>
            Copied
          </div>
           {children}
        </span>
      )
  };
  
  export default Copy;
