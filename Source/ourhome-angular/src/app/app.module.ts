import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { authInterceptorProviders } from './helpers/auth.interceptor';

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
    CustomTestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
