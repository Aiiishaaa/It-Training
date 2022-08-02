import { Session } from "./session";

export interface Formateur {
    id?: number;
    nom?: string;
    prenom?: string;
    email?: string;
    password?: string;
    sessions?: Session[];
}
