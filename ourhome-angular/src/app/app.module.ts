import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Home/home/home.component';
import { PerfilComponent } from './Home/perfil/perfil.component';
import { ProcesosComponent } from './Home/procesos/procesos.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CrearAnuncioComponent } from './Anuncios/crear-anuncio/crear-anuncio.component';
import { VerAnuncioComponent } from './Anuncios/ver-anuncio/ver-anuncio.component';
import { CrearCuestionarioComponent } from './Cuestionarios/crear-cuestionario/crear-cuestionario.component';
import { CuestionarioInicialComponent } from './Cuestionarios/cuestionario-inicial/cuestionario-inicial.component';
import { CuestionarioPersonalizadoComponent } from './Cuestionarios/cuestionario-personalizado/cuestionario-personalizado.component';

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
    CuestionarioPersonalizadoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
