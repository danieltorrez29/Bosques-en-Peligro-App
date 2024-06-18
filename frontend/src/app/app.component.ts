import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './componetes/header/header.component';
import { HomeComponent } from './page/home/home.component';
import { FooterComponent } from './componetes/footer/footer.component';
import { NoticiasComponent } from './page/noticias/noticias.component';
import { DatosComponent } from './page/datos/datos.component';
import { ProyectosComponent } from './page/proyectos/proyectos.component';
import { PostComponent } from './page/post/post.component';
import { LoginComponent } from './page/login/login.component';
import { FormsModule } from '@angular/forms';
<<<<<<< HEAD
=======
import { HttpClientModule } from '@angular/common/http';
>>>>>>> 0bb3f7c053d0cfbd1facc6a70eebcd025f90da2b
import { RegistroComponent } from './page/registro/registro.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HeaderComponent,
    HomeComponent,
    DatosComponent,
    ProyectosComponent,
    NoticiasComponent,
    PostComponent,
    LoginComponent,
    FooterComponent,
    FormsModule,
<<<<<<< HEAD
    RegistroComponent 
=======
    HttpClientModule,
    RegistroComponent
>>>>>>> 0bb3f7c053d0cfbd1facc6a70eebcd025f90da2b
  ],

  
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})


export class AppComponent {

}
