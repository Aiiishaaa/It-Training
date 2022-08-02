import { Role } from "./role";

export interface Employe {
    
    id?: number;
    nomEmploye?: string;
    prenomEmploye?: string;
    passwordEmploye?: string;
    emailEmploye?: string;
    roles?: Role[];

}
