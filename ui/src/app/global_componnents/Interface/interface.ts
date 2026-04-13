import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CountryModel } from '../../models/countryModel';

@Component({
  selector: 'app-interface',
  imports: [RouterOutlet],
  templateUrl: './interface.html',
  styleUrls: ['./interface.css']
})

export class Interface {
    country: CountryModel = {
      name: '',
      capital: '',
      population: 0,
      map: ''
    }
}