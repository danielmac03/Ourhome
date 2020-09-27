import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { PerfilComponent } from './perfil/perfil.component';
import { ProcesosComponent } from './procesos/procesos.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CrearAnuncioComponent } from './crear-anuncio/crear-anuncio.component';
import { VerAnuncioComponent } from './ver-anuncio/ver-anuncio.component';
import { CrearCuestionarioComponent } from './crear-cuestionario/crear-cuestionario.component';
import { CuestionarioInicialComponent } from './cuestionario-inicial/cuestionario-inicial.component';
import { CuestionarioPersonalizadoComponent } from './cuestionario-personalizado/cuestionario-personalizado.component';
import { InfoComponent } from './info/info.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PerfilComponent,
    ProcesosComponent,
    LoginComponent,
    RegisterComponent,
    CrearAnuncioComponent,
    VerAnuncioComponent,
    CrearCuestionarioComponent,
    CuestionarioInicialComponent,
    CuestionarioPersonalizadoComponent,
    InfoComponent,
    NotFoundComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
