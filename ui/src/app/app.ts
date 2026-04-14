import { Component, signal, Input } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Interface } from './global_componnents/Interface/interface';
import * as L from 'leaflet';
import { CountryModel } from './models/countryModel';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Interface],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ui');

  constructor(private http: HttpClient) {}
  private map!: L.Map;
  public country: CountryModel = {
    name: '',
    capital: '',
    population: 0,
    map: ''
  };


  ngAfterViewInit(): void {
    this.loadCountryData();
    this.initMap();

  }

  checkCountry(data: string): void {
    if (data) {
      this.updateMap();
    }
  }

  private loadCountryData(): void {
    this.http.get<any>('http://localhost:8080/api/country/random_country')
  .subscribe((data: any) => {
    this.country = data;
  });
  }

  private updateMap(): void {
    if (this.country.map) {
      this.http.get(this.country.map + ".json").subscribe((geojson: any) => {
        L.geoJSON(geojson).addTo(this.map);
      });
    } else {
      console.error('No map URL provided for the country.');
    }
  }

  private initMap(): void {
    this.map = L.map('map').setView([48.8566, 2.3522], 5);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; OpenStreetMap'
    }).addTo(this.map);
  }

}
