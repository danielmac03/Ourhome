import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';
import {RecoveryPasswordService} from '../service/recovery-password.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  constructor(
    private router: Router,
    private recoveryPasswordService: RecoveryPasswordService
  ) {
  }

  ngOnInit(): void {
  }

  onSubmit(data: NgForm): void {
    this.recoveryPasswordService.forgotPassword(data.value.email).subscribe(resp => {
      alert('Se ha enviado un email para recuperar su contraseña');
      this.router.navigate(['login']);
    });
  }

}
