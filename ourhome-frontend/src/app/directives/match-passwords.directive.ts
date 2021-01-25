import {Directive} from '@angular/core';
import {AbstractControl, NG_VALIDATORS, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';

@Directive({
  selector: '[appMatchPasswords]',
  providers: [{provide: NG_VALIDATORS, useExisting: MatchPasswordsDirective, multi: true}]
})
export class MatchPasswordsDirective implements Validators {

  constructor() {
  }

  validate(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      return control.get('password').value === control.get('passwordVerify').value ? null : {notMatch: true};
    };
  }

}
