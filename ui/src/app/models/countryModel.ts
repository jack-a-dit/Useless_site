export interface CountryModel {
    name: string;
    capital: string;
    population: number;
    map: string;
}

export interface CountryToMap {
    name: string;
    latitude: number;
    longitude: number;
}