import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { RequireGuestHelper } from './helpers/require-guest.helper';
import { RequireLoginHelper } from './helpers/require-login.helper';
import { ProcessesComponent } from './processes/processes.component';
import { CustomTestComponent } from './custom-test/custom-test.component';
import { CreateTestComponent } from './create-test/create-test.component';
import { SeeRequestsComponent } from './see-requests/see-requests.component';
import { InitialTestComponent } from './initial-test/initial-test.component';
import { RequireRoleBusinessHelper } from './helpers/require-role-business.helper';
import { SeeAdvertisementComponent } from './see-advertisement/see-advertisement.component';
import { CreateAdvertisementComponent } from './create-advertisement/create-advertisement.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', component: HomeComponent},
  {path: 'home/:city', component: HomeComponent},
  {path: 'initialTest', component: InitialTestComponent},
  {path: 'seeAdvertisement/:home', component: SeeAdvertisementComponent},
  {path: 'login', component: LoginComponent, canActivate: [RequireGuestHelper]},
  {path: 'register', component: RegisterComponent, canActivate: [RequireGuestHelper]},
  {path: 'profile/:id', component: ProfileComponent, canActivate: [RequireLoginHelper]},
  {path: 'processes', component: ProcessesComponent, canActivate: [RequireLoginHelper]},
  {path: 'createTest', component: CreateTestComponent, canActivate: [RequireLoginHelper]},
  {path: 'customTest/:home', component: CustomTestComponent, canActivate: [RequireLoginHelper]},
  {path: 'seeRequests/:home', component: SeeRequestsComponent, canActivate: [RequireRoleBusinessHelper]},
  {path: 'createAdvertisement', component: CreateAdvertisementComponent, canActivate: [RequireLoginHelper]},
  {path: '404', component: NotFoundComponent},
  {path: '**', redirectTo: '/404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
