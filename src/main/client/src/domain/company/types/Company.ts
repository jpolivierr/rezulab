import Address from "../../address/Address";
import { ContactNumber } from "../../contactNumber/ContactNumber";

export type Company = {
    name: string;
    about: string;
    address: Address;
    contactNumbers: ContactNumber[]; 
};