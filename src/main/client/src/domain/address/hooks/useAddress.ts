import { useState } from "react"
import Address from "../Address"

function useAddress() {

    const [address, setAddress] = useState<Address>({
        street: "",
        city: "",
        state: "",
        zipCode: "",
      })
  
  const setStreet = (street: string): void => {
    setAddress((prevState) => ({
        ...prevState,
        street
    }))
  }
  
  const setCity = (city: string): void => {
    setAddress((prevState) => ({
        ...prevState,
        city
    }))
  } 

  const setState = (state: string): void => {
    setAddress((prevState) => ({
        ...prevState,
        state
    }))
  } 

  const setZipCode = (zipCode: string): void => {
    setAddress((prevState) => ({
        ...prevState,
        zipCode
    }))
  } 

  return (
    {
        address,
        setStreet,
        setCity,
        setState,
        setZipCode
    }
  )
}

export default useAddress