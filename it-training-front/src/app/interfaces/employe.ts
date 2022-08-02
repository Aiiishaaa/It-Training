import { Role } from "./role";

export interface Employe {
    
    id?: number;
    nom?: string;
    prenom?: string;
    password?: string;
    email?: string;
    role?: Role;

}
