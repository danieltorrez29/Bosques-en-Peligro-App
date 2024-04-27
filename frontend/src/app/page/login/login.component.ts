import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { HeaderComponent } from '../../componetes/header/header.component';
import { FooterComponent } from '../../componetes/footer/footer.component';
import { SliderComponent } from '../../componetes/slider/slider.component';
import { SliderModule } from '../../componetes/slider/slider.module';
import { AcercaDeComponent } from '../../componetes/acerca-de/acerca-de.component';
import { ProyectosComponent } from '../../componetes/proyectos/proyectos.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    HeaderComponent,
    FooterComponent
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

}
