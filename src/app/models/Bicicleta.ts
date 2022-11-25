import { Empresa } from './Empresa';
export interface Bicicleta {
    id: number;
    modelo: string;
    marca: string;
    color: string;
    tipo: string;
    imagen: string;
    empresa: Empresa;
}