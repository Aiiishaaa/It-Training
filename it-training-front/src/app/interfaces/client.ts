import { Session } from "./session";

export interface Client {
    id?: number;
    nom?: string;
    prenom?: string;
    email?: string;
    password?:
    {
        pwd: string;
        confirmPwd: string;
    };
    sessions?: Session[];
}
