import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MicomponenteComponent } from './micomponente/micomponente.component';
import { HomeComponent } from './Home/home/home.component';
import { PerfilComponent } from './Home/perfil/perfil.component';
import { ProcesosComponent } from './Home/procesos/procesos.component';
import { CuestionariosComponent } from './Home/cuestionarios/cuestionarios.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CuestionarioComponent } from './cuestionario/cuestionario.component';
import { CuestionarioPersonalizadoComponent } from './cuestionario-personalizado/cuestionario-personalizado.component';
import { VerAnuncioComponent } from './Anuncio/ver-anuncio/ver-anuncio.component';
import { CrearAnuncioComponent } from './Anuncio/crear-anuncio/crear-anuncio.component';
import { CrearCuestionarioPersonalizadoComponent } from './crear-cuestionario-personalizado/crear-cuestionario-personalizado.component';

@NgModule({
  declarations: [
    AppComponent,
    MicomponenteComponent,
    HomeComponent,
    PerfilComponent,
    ProcesosComponent,
    CuestionariosComponent,
    LoginComponent,
    RegisterComponent,
    CuestionarioComponent,
    CuestionarioPersonalizadoComponent,
    VerAnuncioComponent,
    CrearAnuncioComponent,
    CrearCuestionarioPersonalizadoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
