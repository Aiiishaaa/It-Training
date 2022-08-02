import { Session } from "./session";

export interface Formation {

    id?: number;
    // theme?: Theme;
    // domaine?: Domaine;
    prix?: number;
    // prerequis?: Prerequis;
    descriptionBreve?: string;
    descriptionLongue?: string;
    programme?: string;
    // employe?: Employe;
    sessions?: Session[];
    intitule?: string;
    nbHeures?: number;
}
