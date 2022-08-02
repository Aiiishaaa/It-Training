import { FormateurComponent } from "../composants/formateur/formateur.component";
import { Adresse } from "./adresse";
import { Client } from "./client";
import { Formateur } from "./formateur";
import { Formation } from "./formation";

export interface Session {
    id?: number;
    dateDebut ?: Date;
    dateFin ?: Date;
    formation ?: Formation;
    formateur ?: Formateur;
    adresse ?: Adresse;
    client ?: Client;
}
