import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './Home/home/home.component';
import { PerfilComponent } from './Home/perfil/perfil.component';
import { ProcesosComponent } from './Home/procesos/procesos.component';

import { CrearAnuncioComponent } from './Anuncios/crear-anuncio/crear-anuncio.component';
import { VerAnuncioComponent } from './Anuncios/ver-anuncio/ver-anuncio.component';

import { CrearCuestionarioComponent } from './Cuestionarios/crear-cuestionario/crear-cuestionario.component';
import { CuestionarioInicialComponent } from './Cuestionarios/cuestionario-inicial/cuestionario-inicial.component';
import { CuestionarioPersonalizadoComponent } from './Cuestionarios/cuestionario-personalizado/cuestionario-personalizado.component';

import { LoginComponent } from './login/login.component';

import { RegisterComponent } from './register/register.component';

import { InfoComponent } from './Info/info/info.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', component:HomeComponent},
  {path: 'perfil', component:PerfilComponent},
  {path: 'procesos', component:ProcesosComponent},
  {path: 'crearAnuncio', component:CrearAnuncioComponent},
  {path: 'verAnuncio', component:VerAnuncioComponent},
  {path: 'crearCuestionario', component:CrearCuestionarioComponent},
  {path: 'cuestionarioInicial', component:CuestionarioInicialComponent},
  {path: 'cuestionarioPersonalizado', component:CuestionarioPersonalizadoComponent},
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegisterComponent},
  {path: '404', component: InfoComponent},
  {path: '**', redirectTo: '/404'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
