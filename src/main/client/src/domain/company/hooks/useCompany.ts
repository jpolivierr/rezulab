import { useEffect, useState } from 'react'
import { Company } from '../types/Company'
import { PHONE_TYPE } from '../../../constants/PhoneType'

export default function useCompany() {

    const [company, setCompany] = useState<Company>({
        name: "",
        about: "",
        address: {
          street: "",
          city: "",
          state: "",
          zipCode: "",
        },
        contactNumbers: [],
      })

      const getStreet = () => company.address.street;
      const getCity = () => company.address.city;
      const getState = () => company.address.state;
      const getZipCode = () => company.address.zipCode;

      const MAX_NUM_COUNT = 4
      const [maxNumCount, setMaxNumCount] = useState<boolean>(false)

      useEffect(() => {
        if(company.contactNumbers.length >= MAX_NUM_COUNT){
          setMaxNumCount(true)
        }else{
          setMaxNumCount(false)
        }
      },[company.contactNumbers])

      const setName = (name: string) => {
        setCompany((preState) => ({...preState, name}))
      }

      const setAbout= (about: string) => {
        setCompany((preState) => ({...preState, about}))
      }

      const addContactNumber = (): void => {
        if(company.contactNumbers.length >= MAX_NUM_COUNT) return
        setCompany((prevState) => ({
          ...prevState,
          contactNumbers: [
            ...prevState.contactNumbers,
            {
              type: PHONE_TYPE[0],
              ext: "",
              number: ""
            }
          ]
        }))
      }

      const removeContactNumber = (indexToRemove: number): void => {
        setCompany((prevState) => ({
          ...prevState,
          contactNumbers: prevState.contactNumbers.filter((_, index) => index !== indexToRemove),
        }));
      };
      

      const setNumberExt = (index: number, ext: string) => {
        setCompany((prevState) => {
          const updatedContactNumbers = [...prevState.contactNumbers];
          updatedContactNumbers[index] = {
            ...updatedContactNumbers[index],
            ext,
          };
          return {
            ...prevState,
            contactNumbers: updatedContactNumbers,
          };
        });
      };

      const setNumber = (index: number, number: string) => {
        setCompany((prevState) => {
          const updatedContactNumbers = [...prevState.contactNumbers];
          updatedContactNumbers[index] = {
            ...updatedContactNumbers[index],
            number,
          };
          return {
            ...prevState,
            contactNumbers: updatedContactNumbers,
          };
        });
      };

      const setNumberType = (index: number, type: string) => {
        setCompany((prevState) => {
          const updatedContactNumbers = [...prevState.contactNumbers];
          updatedContactNumbers[index] = {
            ...updatedContactNumbers[index],
            type,
          };
          return {
            ...prevState,
            contactNumbers: updatedContactNumbers,
          };
        });
      };

      const setStreet = (street: string): void => {
        setCompany((prevState) => ({
            ...prevState,
            address: {...prevState.address, street}
        }))
      }  

      const setCity = (city: string): void => {
        setCompany((prevState) => ({
            ...prevState,
            address: {...prevState.address, city}
        }))
      }  

      const setState = (state: string): void => {
        setCompany((prevState) => ({
            ...prevState,
            address: {...prevState.address, state}
        }))
      }

      const setZipCode = (zipCode: string): void => {
        setCompany((prevState) => ({
            ...prevState,
            address: {...prevState.address, zipCode}
        }))
      }

      const removeAddress = () => {
        setCompany((prevState) => ({
          ...prevState,
          address: {...prevState.address, 
                    street: "",
                    city: "",
                    state: "",
                    zipCode: ""
          }
      }))
      }

   return {
    maxNumCount,
    company,
    setName,
    setAbout,
    addContactNumber,
    removeContactNumber,
    setNumberType,
    setNumberExt,
    setNumber,
    setStreet,
    getStreet,
    setCity,
    getCity,
    setState,
    getState,
    setZipCode,
    getZipCode,
    removeAddress
   }
}
