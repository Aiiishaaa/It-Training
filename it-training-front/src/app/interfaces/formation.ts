import { Domaine } from "./domaine";
import { Employe } from "./employe";
import { Prerequis } from "./prerequis";
import { Session } from "./session";
import { Theme } from "./theme";

export interface Formation {

    id?: number;
    theme?: Theme;
    domaine?: Domaine;
    prix?: number;
    prerequis?: Prerequis;
    descriptionBreve?: string;
    descriptionLongue?: string;
    programme?: string;
    employe?: Employe;
    sessions?: Session[];
    intitule?: string;
    nbHeures?: number;
}
