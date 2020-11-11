import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { ProcessesComponent } from './processes/processes.component';
import { CustomTestComponent } from './custom-test/custom-test.component';
import { CreateTestComponent } from './create-test/create-test.component';
import { SeeRequestsComponent } from './see-requests/see-requests.component';
import { InitialTestComponent } from './initial-test/initial-test.component';
import { RequireRolesHelper } from './helpers/require-roles.helper';
import { SeeAdvertisementComponent } from './see-advertisement/see-advertisement.component';
import { CreateAdvertisementComponent } from './create-advertisement/create-advertisement.component';

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
    path: 'home/:city',
    component: HomeComponent
  },
  {path: 'initialTest',
    component: InitialTestComponent
  },
  {path: 'seeAdvertisement/:home',
    component: SeeAdvertisementComponent
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
    path: 'register',
    component: RegisterComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: [undefined],
    }
  },
  {
    path: 'profile/:id',
    component: ProfileComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['search', 'have', 'business'],
    }
  },
  {
    path: 'list-processes',
    component: ProcessesComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['search', 'business']
    }
  },
  {
    path: 'createTest',
    component: CreateTestComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['have', 'business']
    }
  },
  {
    path: 'customTest/:home',
    component: CustomTestComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['search']
    }
  },
  {
    path: 'seeRequests',
    component: SeeRequestsComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['have'],
    }
  },
  {
    path: 'seeRequests/:home',
    component: SeeRequestsComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['business'],
    }
  },
  {
    path: 'createAdvertisement',
    component: CreateAdvertisementComponent,
    canActivate: [RequireRolesHelper],
    data: {
      allowedRoles: ['have', 'business'],
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
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
