import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { HeaderComponent } from '../../componetes/header/header.component';
import { FooterComponent } from '../../componetes/footer/footer.component';
import { SliderComponent } from '../../componetes/slider/slider.component';
import { SliderModule } from '../../componetes/slider/slider.module';
import { AcercaDeComponent } from '../../componetes/acerca-de/acerca-de.component';
import { ProyectosComponent } from '../../componetes/proyectos/proyectos.component';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    HeaderComponent,
    FooterComponent,
    SliderModule,
    AcercaDeComponent,
    ProyectosComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
