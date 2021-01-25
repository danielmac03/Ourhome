import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';


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
import {CreateAccountComponent} from './create-account/create-account.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {HeaderComponent} from './header/header.component';
import {SeeRequestsComponent} from './see-requests/see-requests.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatStepperModule} from '@angular/material/stepper';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {MatRippleModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatRadioModule} from '@angular/material/radio';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {PlansComponent} from './plans/plans.component';
import {ForgotPasswordComponent} from './forgot-password/forgot-password.component';
import {RecoveryPasswordComponent} from './recovery-password/recovery-password.component';
import {WishlistComponent} from './wishlist/wishlist.component';
import {IsInWishlistPipe} from './pipes/is-in-wishlist.pipe';
import {ExistEmailDirective} from './directives/exist-email.directive';

import {authInterceptorHelper} from './helpers/auth-interceptor.helper';
import {httpErrorsInterceptorHelper} from './helpers/http-errors-interceptor.helper';
import {RequireRolesHelper} from './helpers/require-roles.helper';
import {CheckCompatibilityHelper} from './helpers/check-compatibility.helper';
import {MatchPasswordsDirective} from './directives/match-passwords.directive';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    CreateAccountComponent,
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
    PlansComponent,
    ForgotPasswordComponent,
    RecoveryPasswordComponent,
    WishlistComponent,
    IsInWishlistPipe,
    ExistEmailDirective,
    MatchPasswordsDirective
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
    MatInputModule,
    MatChipsModule,
    MatIconModule,
    MatRadioModule,
    MatCheckboxModule
  ],
  providers: [
    authInterceptorHelper,
    httpErrorsInterceptorHelper,
    RequireRolesHelper,
    CheckCompatibilityHelper,
    ExistEmailDirective,
    MatchPasswordsDirective
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
