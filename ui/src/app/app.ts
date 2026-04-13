import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Interface } from './global_componnents/Interface/interface';
import * as L from 'leaflet';
import { CountryModel } from './models/countryModel';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Interface],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ui');

  private map!: L.Map;

  ngAfterViewInit(): void {
    this.initMap();
  }

  private initMap(): void {
    this.map = L.map('map').setView([48.8566, 2.3522], 5);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; OpenStreetMap'
    }).addTo(this.map);
  }

}
