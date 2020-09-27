import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { ProcessesComponent } from './processes/processes.component';
import { CrearAnuncioComponent } from './crear-anuncio/crear-anuncio.component';
import { VerAnuncioComponent } from './ver-anuncio/ver-anuncio.component';
import { CrearCuestionarioComponent } from './crear-cuestionario/crear-cuestionario.component';
import { CuestionarioInicialComponent } from './cuestionario-inicial/cuestionario-inicial.component';
import { CuestionarioPersonalizadoComponent } from './cuestionario-personalizado/cuestionario-personalizado.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', component:HomeComponent},
  {path: 'profile', component:ProfileComponent},
  {path: 'processes', component:ProcessesComponent},
  {path: 'crearAnuncio', component:CrearAnuncioComponent},
  {path: 'verAnuncio', component:VerAnuncioComponent},
  {path: 'crearCuestionario', component:CrearCuestionarioComponent},
  {path: 'cuestionarioInicial', component:CuestionarioInicialComponent},
  {path: 'cuestionarioPersonalizado', component:CuestionarioPersonalizadoComponent},
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
