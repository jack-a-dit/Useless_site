import { Component, signal, Input, Output, EventEmitter } from '@angular/core';
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
    @Input() country: CountryModel = {
      name: '',
      capital: '',
      population: 0,
      map: ''
    }
    @Output() countryChecked = new EventEmitter<string>();
    guess: string = '';
    attemptsLeft: number = 3;
    isWrong: boolean = false;

    CheckCountry() {
      if (this.guess.toLowerCase() === this.country.name.toLowerCase()) {
        alert('Correct! The country is ' + this.country.name);
        this.countryChecked.emit("true");
      } else {
        this.attemptsLeft--;
        this.isWrong = true;
      }
      if (this.attemptsLeft === 0) {
        alert('Game Over! The correct answer was ' + this.country.name);
        this.countryChecked.emit("false");
      }
    }

}