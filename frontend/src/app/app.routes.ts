import { Routes } from '@angular/router';
import { HomeComponent } from './page/home/home.component';
import { NoticiasComponent } from './page/noticias/noticias.component';
import { DatosComponent } from './page/datos/datos.component';
import { ProyectosComponent } from './page/proyectos/proyectos.component';
import { PostComponent } from './page/post/post.component';
import { LoginComponent } from './page/login/login.component';
import { RegistroComponent } from './page/registro/registro.component';
<<<<<<< HEAD
=======

>>>>>>> 0bb3f7c053d0cfbd1facc6a70eebcd025f90da2b


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
<<<<<<< HEAD
    }, 
    {
        path: 'registro', 
        component: RegistroComponent 
    }, 
=======
    },
    {
        path: 'registro', 
        component: RegistroComponent
    }
  
>>>>>>> 0bb3f7c053d0cfbd1facc6a70eebcd025f90da2b
];

