import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FormControl, FormGroup, FormGroupDirective, Validators} from '@angular/forms';
import {UsersService} from '../service/users.service';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-initial-test',
  templateUrl: './initial-test.component.html',
  styleUrls: ['./initial-test.component.css']
})
export class InitialTestComponent implements OnInit {

  form;

  constructor(
    private router: Router,
    private usersService: UsersService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      p1: new FormControl('', [Validators.required]),
      p2: new FormControl('', [Validators.required]),
      p3: new FormControl('', [Validators.required]),
      p4: new FormControl('', [Validators.required]),
      p5: new FormControl('', [Validators.required]),
      p6: new FormControl('', [Validators.required]),
      p7: new FormControl('', [Validators.required]),
      p8: new FormControl('', [Validators.required]),
      p9: new FormControl('', [Validators.required]),
      p10: new FormControl('', [Validators.required])
    });
  }

  onSubmit(data: FormGroupDirective): void {
    const user = this.tokenStorageService.getUser();
    user.defaultTestResponses = JSON.stringify(data.value);

    const formData = new FormData();
    formData.append('user', new Blob([JSON.stringify(user)], {type: 'application/json'}));

    this.usersService.updateUser(formData).subscribe(resp => {
      this.tokenStorageService.saveUser(resp);

      this.router.navigate(['home']);
    });
  }
}
