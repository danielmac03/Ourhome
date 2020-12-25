import { Injectable } from '@angular/core';
import { TokenStorageService } from '../service/token-storage.service';

@Injectable()
export class CheckCompatibilityHelper {

  constructor(private tokenStorageService: TokenStorageService) { }

  check(defaultTestResponses: string): boolean {
    const user = this.tokenStorageService.getUser();

    if (user !== '' && (user.role === 'business' || user.defaultTestResponses !== null)) {
      const userDefaultTestResponses = JSON.parse(user.defaultTestResponses);
      defaultTestResponses = JSON.parse(defaultTestResponses);

      let contador = 0;
      for (let i = 1; i < Object.keys(userDefaultTestResponses).length + 1; i++) {
        if (defaultTestResponses['p' + i] === userDefaultTestResponses['p' + i]) {
          contador++;
        }
      }

      if (contador > Object.keys(userDefaultTestResponses).length / 2) {
        return false;
      }
    } else {
      return false;
    }

    return true;
  }
}
