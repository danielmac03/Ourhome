import {Pipe, PipeTransform} from '@angular/core';
import {WishesService} from '../service/wishes.service';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Pipe({
  name: 'isInWishlist'
})
export class IsInWishlistPipe implements PipeTransform {

  constructor(
    private wishesService: WishesService
  ) {
  }

  transform(value: any, userRole: string, userId: number, homeId: number): Observable<boolean> {
    if (userRole === 'search') {
      return this.wishesService.isInWishlist(userId, homeId).pipe(map(resp => {
        value = resp;
        return value;
      }));
    }
  }

}
