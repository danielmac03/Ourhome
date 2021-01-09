import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {RecoveryPasswordService} from '../service/recovery-password.service';

@Component({
  selector: 'app-recovery-password',
  templateUrl: './recovery-password.component.html',
  styleUrls: ['./recovery-password.component.css']
})
export class RecoveryPasswordComponent implements OnInit {

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private recoveryPasswordService: RecoveryPasswordService
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
  }

  onSubmit(data: NgForm): void {
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
