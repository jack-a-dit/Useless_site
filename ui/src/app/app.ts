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
  imports: [RouterOutlet, Interface],
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
      this.updateMap();
      if (data === "reload") {
        this.map.flyTo([48.8566, 2.3522], 5);
        this.loadCountryData();
      }
    }
    console.log("checkCountry called with data:", data);
  }

  private loadCountryData(): void {
    this.http.get<any>('http://localhost:8080/api/country/random_country')
  .subscribe((data: any) => {
    this.country = { ...data };
    this.country = { ...this.country };
    this.cdr.detectChanges();
  });
  }

  private updateMap(): void {
    const lat = this.country.map.latitude;
    const lng = this.country.map.longitude;

    if (this.country.map) {
      this.map.flyTo([lat, lng], 5);
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
