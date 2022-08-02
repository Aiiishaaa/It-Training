import { Domaine } from "./domaine";
import { Formation } from "./formation";

export interface Theme {

    id?: number;
    nomTheme?: string;
    domaine?: Domaine;
    formations?: Formation[];
}
