import { ContactNumber } from "../../contactNumber/ContactNumber";

export type Company = {
    name: string;
    about: string;
    address: Object;
    contactNumbers: ContactNumber[]; 
};