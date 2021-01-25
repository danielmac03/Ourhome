import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup, FormGroupDirective, Validators} from '@angular/forms';
import {RecoveryPasswordService} from '../service/recovery-password.service';
import {MatchPasswordsDirective} from '../directives/match-passwords.directive';

@Component({
  selector: 'app-recovery-password',
  templateUrl: './recovery-password.component.html',
  styleUrls: ['./recovery-password.component.css']
})
export class RecoveryPasswordComponent implements OnInit {

  form;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private recoveryPasswordService: RecoveryPasswordService,
    private mustMatchDirective: MatchPasswordsDirective
  ) {
  }

  ngOnInit(): void {
    const token = {
      user: {
        email: this.route.snapshot.params.email
      },
      token: this.route.snapshot.params.token
    };

    this.recoveryPasswordService.isValid(token).subscribe();

    this.form = new FormGroup({
      password: new FormControl('', [Validators.required]),
      passwordVerify: new FormControl('', [Validators.required]),
    }, {
      validators: this.mustMatchDirective.validate()
    });
  }

  onSubmit(data: FormGroupDirective): void {
    const token = {
      user: {
        email: this.route.snapshot.params.email
      },
      token: this.route.snapshot.params.token
    };

    const formData = new FormData();

    formData.append('token', new Blob([JSON.stringify(token)], {type: 'application/json'}));
    formData.append('password', new Blob([data.value.password], {type: 'application/json'}));

    this.recoveryPasswordService.recoveryPassword(formData).subscribe(resp => {
      alert('Se ha restablecido correctamente');
      this.router.navigate(['login']);
    });
  }

}
