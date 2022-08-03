import { Session } from "./session";

export interface Formateur {
    id?: number;
    nomFormateur?: string;
    prenomFormateur?: string;
    emailFormateur?: string;
    passwordFormateur?: string;
    sessions?: Session[];
}
