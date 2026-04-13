import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common'; 
import { FormsModule } from '@angular/forms';
import { CountryModel } from '../../models/countryModel';

@Component({
  selector: 'app-interface',
  imports: [RouterOutlet, CommonModule, FormsModule],
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
    guess: string = '';
    attemptsLeft: number = 3;
    isWrong: boolean = false;

    CheckCountry() {
        // Implementation for checking the country
    }

}