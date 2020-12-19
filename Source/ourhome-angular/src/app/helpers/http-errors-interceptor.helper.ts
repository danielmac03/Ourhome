import {Injectable} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable, of} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable()
export class HttpErrorsInterceptorHelper implements HttpInterceptor {

  constructor(
    private router: Router
  ) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      catchError((error) => {
        switch (error.status) {
          default:
            this.router.navigate(['404']);
            break;
        }

        return of(error);
      })
    );
  }
}

export const httpErrorsInterceptorHelper = [
  {provide: HTTP_INTERCEPTORS, useClass: HttpErrorsInterceptorHelper, multi: true}
];
