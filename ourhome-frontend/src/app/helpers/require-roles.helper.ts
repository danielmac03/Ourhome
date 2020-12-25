import { Injectable } from '@angular/core';
import {Router, CanActivate, ActivatedRouteSnapshot} from '@angular/router';
import { TokenStorageService } from '../service/token-storage.service';

@Injectable()
export class RequireRolesHelper implements CanActivate {

  constructor(
    private router: Router,
    private tokenStorageService: TokenStorageService
  ) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const allowedRoles = route.data.allowedRoles;
    const redirectTo = (route.data.redirectTo) ? route.data.redirectTo : 'home';
    const user = this.tokenStorageService.getUser();
    let result = false;

    for (const role of allowedRoles){
      if (user.role === role || user.role === 'admin'){
        result = true;
      }
    }

    if (!result){
      alert('No puedes acceder a esta sección \nDisculpe las molestias');
      this.router.navigate([redirectTo]);
    }

    return result;
  }

}
