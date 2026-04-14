import { Component, signal, Input } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Interface } from './global_componnents/Interface/interface';
import * as L from 'leaflet';
import { CountryModel, CountryToMap } from './models/countryModel';
import { HttpClient} from '@angular/common/http';
import { JsonPipe } from '@angular/common';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Interface, JsonPipe],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ui');

  constructor(private http: HttpClient, private cdr: ChangeDetectorRef) {}

  private map!: L.Map;
  public country: CountryModel = {
    name: '',
    capital: '',
    population: 0,
    map: {
      url: '',
      latitude: 48.8566,
      longitude: 2.3522
    }
  };
  urlMap: string = '';

  ngOnInit(): void {
    this.loadCountryData();
  }

  ngAfterViewInit(): void {
    this.initMap();
  }

  checkCountry(data: string): void {
    if (data) {
      console.log("guess received in parent component.");
      this.updateMap();
    }
    console.log("checkCountry called with data:", data);
  }

  private getRelationIdFromCountryMapUrl(mapUrl: string): string | null {
    const match = mapUrl.match(/\/relation\/(\d+)/);
    return match ? match[1] : null;
  }

  private loadCountryData(): void {
    this.http.get<any>('http://localhost:8080/api/country/random_country')
  .subscribe((data: any) => {
    console.log("Données reçues du backend :", data);
    this.country = { ...data };
    this.country = { ...this.country };
    this.cdr.detectChanges();
    console.log("Country data updated in component:", this.country);
  });
  }

  private updateMap(): void {
//    if (this.country.map) {
//       this.urlMap = 'https://api.openstreetmap.org/api/0.6/relation/' + this.getRelationIdFromCountryMapUrl(this.country.map) + '.json';
//      this.http.get(this.urlMap).subscribe((geojson: any) => {
//        L.geoJSON(geojson).addTo(this.map);
//      });
//    } else {
//      console.error('No map URL provided for the country.');
//    }
  }

  private initMap(): void {
    this.map = L.map('map').setView([48.8566, 2.3522], 5);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; OpenStreetMap'
    }).addTo(this.map);
  }

}
