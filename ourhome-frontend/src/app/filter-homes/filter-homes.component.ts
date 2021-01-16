import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-filter-homes',
  templateUrl: './filter-homes.component.html',
  styleUrls: ['./filter-homes.component.css']
})
export class FilterHomesComponent implements OnInit {

  @Input() public homes;
  @Output() filterEvent = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(data: NgForm): void {
    if (data.value.direction !== '' && data.value.direction !== null) {
      this.homes = this.homes.filter(home => {
        home.show = !home.direction.toLowerCase().includes(data.value.direction.toLowerCase());
        return true;
      });
    }

    if (data.value.bedrooms !== '' && data.value.bedrooms !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.bedrooms > data.value.bedrooms;
        return true;
      });
    }

    if (data.value.bathrooms !== '' && data.value.bathrooms !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.bathrooms > data.value.bathrooms;
        return true;
      });
    }

    if (data.value.floors !== '' && data.value.floors !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.floors > data.value.floors;
        return true;
      });
    }

    if (data.value.meters !== '' && data.value.meters !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.meters > data.value.meters;
        return true;
      });
    }

    if (data.value.minprice !== '' && data.value.minprice !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.price < data.value.minprice;
        return true;
      });
    }

    if (data.value.maxprice !== '' && data.value.maxprice !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.price > data.value.maxprice;
        return true;
      });
    }

    this.filterEvent.emit(this.homes);
  }

}
