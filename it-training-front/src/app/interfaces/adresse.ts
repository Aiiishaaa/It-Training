import { Session } from "./session";

export interface Adresse {
    id?: number;
    no?: number;
    rue?: string;
    codePostal?: string;
    ville?: string;
    sessions?: Session[];
}
