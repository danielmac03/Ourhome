import { Injectable } from '@angular/core';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Injectable()
export class CheckCompatibilityHelper {

  constructor(private tokenStorageService: TokenStorageService) { }

  check(defaultTestResponses: string): boolean {
    const user = this.tokenStorageService.getUser();

    if (user !== '') {
      const userDefaultTestResponses = user.defaultTestResponses;
      const defaultTestResponsesString = defaultTestResponses;

      let contador = 0;
      for (let i = 0; i < userDefaultTestResponses.length; i++) {
        if (defaultTestResponsesString.charAt(i) === userDefaultTestResponses.charAt(i)) {
          contador++;
        }
      }

      if (contador < userDefaultTestResponses.length / 2) {
        return false;
      }
    } else {
      return false;
    }

    return true;
  }
}
