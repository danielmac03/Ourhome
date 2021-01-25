import {Directive} from '@angular/core';
import {AbstractControl, AsyncValidatorFn, NG_VALIDATORS, ValidationErrors, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {UsersService} from '../service/users.service';
import {TokenStorageService} from '../service/token-storage.service';

@Directive({
  selector: '[appExistEmailValidateDirective]',
  providers: [{provide: NG_VALIDATORS, useExisting: ExistEmailDirective, multi: true}]
})
export class ExistEmailDirective implements Validators {

  constructor(
    private usersService: UsersService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  validate(requireExist: boolean): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors> | null => {
      return this.usersService.existEmail(control.value).pipe(map(resp => {
        if (requireExist) {
          return resp ? null : {existEmail: true};
        } else {
          return resp && control.value !== this.tokenStorageService.getUser().email ? {existEmail: true} : null;
        }
      }));
    };
  }
}
