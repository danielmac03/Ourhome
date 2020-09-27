import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { ProcessesComponent } from './processes/processes.component';
import { CreateAdvertisementComponent } from './create-advertisement/create-advertisement.component';
import { SeeAdvertisementComponent } from './see-advertisement/see-advertisement.component';
import { CreateTestComponent } from './create-test/create-test.component';
import { InitialTestComponent } from './initial-test/initial-test.component';
import { CustomTestComponent } from './custom-test/custom-test.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', component:HomeComponent},
  {path: 'profile', component:ProfileComponent},
  {path: 'processes', component:ProcessesComponent},
  {path: 'createAdvertisement', component:CreateAdvertisementComponent},
  {path: 'seeAdvertisement', component:SeeAdvertisementComponent},
  {path: 'createTest', component:CreateTestComponent},
  {path: 'initialTest', component:InitialTestComponent},
  {path: 'customTest', component:CustomTestComponent},
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegisterComponent},
  {path: '404', component: NotFoundComponent},
  {path: '**', redirectTo: '/404'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
