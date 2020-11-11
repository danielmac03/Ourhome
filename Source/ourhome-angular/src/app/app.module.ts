import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { authInterceptorHelper } from './helpers/auth-interceptor.helper';
import { RequireRolesHelper } from './helpers/require-roles.helper';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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
import { HeaderComponent } from './header/header.component';
import { SeeRequestsComponent } from './see-requests/see-requests.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    NotFoundComponent,
    ProfileComponent,
    ProcessesComponent,
    SeeAdvertisementComponent,
    CreateAdvertisementComponent,
    CreateTestComponent,
    InitialTestComponent,
    CustomTestComponent,
    HeaderComponent,
    SeeRequestsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [authInterceptorHelper, RequireRolesHelper],
  bootstrap: [AppComponent]
})
export class AppModule { }
