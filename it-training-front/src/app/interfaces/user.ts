
import { Session } from "./session";
export interface User {
    id?: number;
    nom?: string;
    prenom?: string;
    email?: string;
    password?: string; 
    sessions?: Session[];
}

