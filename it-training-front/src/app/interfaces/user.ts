import { Formation } from "./formation";
import { Role } from "./role";
import { Session } from "./session";

export interface User {
    id?: number;
    name?: string;
    firstname?: string;
    username?: string;
    email?: string;
    password?: string;
    phone?: string;
    sessions?: Session[];
    roles?: Role[];
    formations?: Formation[];
}
