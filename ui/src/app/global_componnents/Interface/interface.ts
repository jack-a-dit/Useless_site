import { Component, signal, Input, Output, EventEmitter } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common'; 
import { FormsModule } from '@angular/forms';
import { CountryModel } from '../../models/countryModel';

@Component({
  selector: 'app-interface',
  imports: [ CommonModule, FormsModule ],
  templateUrl: './interface.html',
  styleUrls: ['./interface.css']
})

export class Interface {
    @Input() country!: CountryModel;
    @Output() countryChecked = new EventEmitter<string>();
    guess: string = '';
    attemptsLeft: number = 3;
    isWrong: boolean = false;
    gameStatus: string = "playing"

    ngOnChanges() {
      console.log("COUNTRY UPDATE:", this.country);
    }

  retryGame() {
    this.attemptsLeft = 3;
    this.guess = '';
    this.isWrong = false;
    this.gameStatus = 'playing';

    this.countryChecked.emit("reload");
  }

    CheckCountry() {
      if (this.guess.toLowerCase() === this.country.name.toLowerCase()) {
        this.gameStatus = "win";
        this.countryChecked.emit("true");
      } else {
        this.attemptsLeft--;
        this.isWrong = true;
      }
      if (this.attemptsLeft === 0) {
        this.gameStatus = "lost";
        this.countryChecked.emit("false");
        
      }
    }

}