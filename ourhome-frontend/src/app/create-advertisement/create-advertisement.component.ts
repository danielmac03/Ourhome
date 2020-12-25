import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {HomesService} from '../service/homes.service';
import {ProcessesService} from '../service/processes.service';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-create-advertisement',
  templateUrl: './create-advertisement.component.html',
  styleUrls: ['./create-advertisement.component.css']
})
export class CreateAdvertisementComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private homesService: HomesService,
    private processesService: ProcessesService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  user;
  home = {
    id: undefined
  };

  create = true;
  photos = [];
  photosPreview = [];

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();

    if (this.router.url === '/edit-advertisement') {
      if (this.route.snapshot.params.id) {
        this.homesService.getHomeById(this.route.snapshot.params.id).subscribe(resp => {
          this.home = resp;
        });
      } else {
        this.homesService.getHomesByUser(this.user.id).subscribe(resp => {
          this.home = resp[0];
        });
      }

      this.create = false;
    }
  }

  onFileChange(event): void {
    this.photos = [];
    this.photosPreview = [];

    for (const photo of event.target.files) {
      if (photo.type.match(/image\/*/) != null) {
        this.photos.push(photo);

        const reader = new FileReader();
        reader.readAsDataURL(photo);
        reader.onload = () => this.photosPreview.push(reader.result);
      } else {
        alert('Solo debe subir imagenes');
      }
    }
  }

  onSubmit(data: NgForm): void {
    if (this.create) {
      this.onSubmitCreate(data);
    } else {
      this.onSubmitUpdate(data);
    }
  }

  onSubmitCreate(data: NgForm): void {
    data.value.user = this.user;
    data.value.active = true;

    const formData = new FormData();
    formData.append('home', new Blob([JSON.stringify(data.value)], {type: 'application/json'}));

    if (this.photos !== undefined) {
      for (const photo of this.photos) {
        formData.append('photos', photo);
      }
    }

    this.homesService.createHomes(formData).subscribe(resp => {
      this.router.navigate(['home']);
    });
  }

  onSubmitUpdate(data: NgForm): void {
    let check;

    if (data.value.active === false) {
      check = confirm('Si desactiva este anuncio se eliminaran los procesos iniciados, esta seguro?');

      if (check === false) {
        return;
      }
    }

    const homeUpdated = Object.assign(this.home, data.value);

    const formData = new FormData();
    formData.append('home', new Blob([JSON.stringify(homeUpdated)], {type: 'application/json'}));

    if (this.photos !== undefined) {
      for (const photo of this.photos) {
        formData.append('photos', photo);
      }
    }

    this.homesService.updateHome(formData).subscribe(resp1 => {
      if (check === true) {
        this.processesService.deleteProcessesByHome(this.home.id).subscribe(resp2 => {
          console.log('Completed...');
        });
      }

      this.router.navigate(['see-advertisement', this.home.id]);
    });
  }

}
