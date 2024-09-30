import { ReactNode } from "react"

function mainLayout({children}: {children: ReactNode}) {
  return (
    <main className='theme-dark bk'>
        <div className='container'>
          {children}
        </div>
    </main>
  )
}

export default mainLayout