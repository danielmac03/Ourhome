import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {authInterceptorHelper} from './helpers/auth-interceptor.helper';
import {RequireRolesHelper} from './helpers/require-roles.helper';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {ProfileComponent} from './profile/profile.component';
import {ListProcessesComponent} from './list-processes/list-processes.component';
import {CreateAdvertisementComponent} from './create-advertisement/create-advertisement.component';
import {SeeAdvertisementComponent} from './see-advertisement/see-advertisement.component';
import {CreateTestComponent} from './create-test/create-test.component';
import {InitialTestComponent} from './initial-test/initial-test.component';
import {CustomTestComponent} from './custom-test/custom-test.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {HeaderComponent} from './header/header.component';
import {SeeRequestsComponent} from './see-requests/see-requests.component';
import {CheckCompatibilityHelper} from './helpers/check-compatibility.helper';
import {BusinessListHomesComponent} from './business-list-homes/business-list-homes.component';
import {EditAdvertisementComponent} from './edit-advertisement/edit-advertisement.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatStepperModule} from '@angular/material/stepper';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatButtonModule} from "@angular/material/button";
import {MatRippleModule} from "@angular/material/core";
import {MatInputModule} from "@angular/material/input";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    NotFoundComponent,
    ProfileComponent,
    ListProcessesComponent,
    SeeAdvertisementComponent,
    CreateAdvertisementComponent,
    CreateTestComponent,
    InitialTestComponent,
    CustomTestComponent,
    HeaderComponent,
    SeeRequestsComponent,
    BusinessListHomesComponent,
    EditAdvertisementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatStepperModule,
    MatFormFieldModule,
    MatButtonModule,
    MatRippleModule,
    MatInputModule
  ],
  providers: [authInterceptorHelper, RequireRolesHelper, CheckCompatibilityHelper],
  bootstrap: [AppComponent]
})
export class AppModule {
}
