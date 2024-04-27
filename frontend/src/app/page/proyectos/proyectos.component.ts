import { Component } from '@angular/core';
import { HeaderComponent } from '../../componetes/header/header.component';
import { FooterComponent } from '../../componetes/footer/footer.component';
import { SliderComponent } from '../../componetes/slider/slider.component';
import { SliderModule } from '../../componetes/slider/slider.module';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-proyectos',
  standalone: true,
  imports: [
    CommonModule,
    HeaderComponent,
    SliderModule,
    FooterComponent
  ],
  templateUrl: './proyectos.component.html',
  styleUrl: './proyectos.component.css'
})
export class ProyectosComponent {

}
