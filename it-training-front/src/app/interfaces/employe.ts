import { Role } from "./role";

export interface Employe {
    
    id?: number;
    nom?: string;
    prenom?: string;
    password?: string;
    email_employe?: string;
    role?: Role;

}
