import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormGroupDirective, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {RecoveryPasswordService} from '../service/recovery-password.service';
import {ExistEmailDirective} from '../directives/exist-email.directive';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  form;

  constructor(
    private router: Router,
    private recoveryPasswordService: RecoveryPasswordService,
    private existEmailValidateDirectiveDirective: ExistEmailDirective
  ) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email], [this.existEmailValidateDirectiveDirective.validate(true)])
    });
  }

  onSubmit(data: FormGroupDirective): void {
    this.recoveryPasswordService.forgotPassword(data.value.email).subscribe(resp => {
      alert('Se ha enviado un email para recuperar su contraseña');
      this.router.navigate(['login']);
    });
  }

}
