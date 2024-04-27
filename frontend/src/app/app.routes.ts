import { Routes } from '@angular/router';
import { HomeComponent } from './page/home/home.component';
import { NoticiasComponent } from './page/noticias/noticias.component';
import { DatosComponent } from './page/datos/datos.component';
import { ProyectosComponent } from './page/proyectos/proyectos.component';
import { PostComponent } from './page/post/post.component';
import { LoginComponent } from './page/login/login.component';


export const routes: Routes = [
    {
        path: '', 
        component: HomeComponent 
    },
    {
        path: 'noticias', 
        component: NoticiasComponent 
    },
    {
        path: 'datos', 
        component: DatosComponent 
    }, 
    {
        path: 'proyectos', 
        component: ProyectosComponent 
    }, 
    {
        path: 'post', 
        component: PostComponent 
    }, 
    {
        path: 'login', 
        component: LoginComponent 
    }, 
];
