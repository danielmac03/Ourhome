import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {ProfileComponent} from './profile/profile.component';
import {CreateAccountComponent} from './create-account/create-account.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {ListProcessesComponent} from './list-processes/list-processes.component';
import {CustomTestComponent} from './custom-test/custom-test.component';
import {CreateTestComponent} from './create-test/create-test.component';
import {SeeRequestsComponent} from './see-requests/see-requests.component';
import {InitialTestComponent} from './initial-test/initial-test.component';
import {RequireRolesHelper} from './helpers/require-roles.helper';
import {SeeAdvertisementComponent} from './see-advertisement/see-advertisement.component';
import {CreateAdvertisementComponent} from './create-advertisement/create-advertisement.component';
import {PlansComponent} from './plans/plans.component';
import {ForgotPasswordComponent} from './forgot-password/forgot-password.component';
import {RecoveryPasswordComponent} from './recovery-password/recovery-password.component';
import {WishlistComponent} from './wishlist/wishlist.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'initial-test',
    component: InitialTestComponent
  },
  {
    path: 'see-advertisement/:home',
    component: SeeAdvertisementComponent
  },
  {
    path: 'forgot-password',
    component: ForgotPasswordComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: [undefined],
    }
  },
  {
    path: 'recovery-password/:email/:token',
    component: RecoveryPasswordComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: [undefined],
    }
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: [undefined],
    }
  },
  {
    path: 'create-account',
    component: CreateAccountComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: [undefined],
    }
  },
  {
    path: 'create-account-business',
    component: CreateAccountComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: [undefined],
    }
  },
  {
    path: 'profile',
    component: ProfileComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['search', 'have', 'business'],
    }
  },
  {
    path: 'list-processes',
    component: ListProcessesComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['search', 'business']
    }
  },
  {
    path: 'create-test',
    component: CreateTestComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['have', 'business']
    }
  },
  {
    path: 'custom-test/:home',
    component: CustomTestComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['search']
    }
  },
  {
    path: 'see-requests',
    component: SeeRequestsComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['have'],
    }
  },
  {
    path: 'see-requests/:home',
    component: SeeRequestsComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['business'],
    }
  },
  {
    path: 'create-advertisement',
    component: CreateAdvertisementComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['have', 'business'],
    }
  },
  {
    path: 'edit-advertisement',
    component: CreateAdvertisementComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['have'],
    }
  },
  {
    path: 'edit-advertisement/:id',
    component: CreateAdvertisementComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['business'],
    }
  },
  {
    path: 'plans',
    component: PlansComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['business'],
    }
  },
  {
    path: 'wishlist',
    component: WishlistComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['search'],
    }
  },
  {
    path: '404',
    component: NotFoundComponent
  },
  {
    path: '**',
    redirectTo: '/404'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {relativeLinkResolution: 'legacy'})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
