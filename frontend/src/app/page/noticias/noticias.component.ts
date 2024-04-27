import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { HeaderComponent } from '../../componetes/header/header.component';
import { FooterComponent } from '../../componetes/footer/footer.component';
import { SliderComponent } from '../../componetes/slider/slider.component';
import { SliderModule } from '../../componetes/slider/slider.module';

@Component({
  selector: 'app-noticias',
  standalone: true,
  imports: [
    CommonModule,
    HeaderComponent,
    SliderModule,
    FooterComponent
  ],
  templateUrl: './noticias.component.html',
  styleUrl: './noticias.component.css'
})
export class NoticiasComponent {

}
