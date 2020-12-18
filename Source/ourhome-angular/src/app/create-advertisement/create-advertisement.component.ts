import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HomesService} from '../service/homes.service';
import {TokenStorageService} from '../service/authentication/token-storage.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-create-advertisement',
  templateUrl: './create-advertisement.component.html',
  styleUrls: ['./create-advertisement.component.css']
})
export class CreateAdvertisementComponent implements OnInit {

  constructor(
    private homesService: HomesService,
    private router: Router,
    private tokenStorage: TokenStorageService
  ) {
  }

  url;
  photos = [];
  photosPreview = [];

  ngOnInit(): void {
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
    data.value.user = this.tokenStorage.getUser();
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
    }, error => {
      console.log(error);
    });
  }

}
