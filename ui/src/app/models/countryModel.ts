export interface CountryModel {
    name: string;
    capital: string;
    population: number;
    map: CountryToMap;
}

export interface CountryToMap {
    url: string;
    latitude: number;
    longitude: number;
}