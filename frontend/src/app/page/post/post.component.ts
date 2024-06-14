import { Component } from '@angular/core';
import { HeaderComponent } from '../../componetes/header/header.component';
import { FooterComponent } from '../../componetes/footer/footer.component';
import { SliderComponent } from '../../componetes/slider/slider.component';
import { SliderModule } from '../../componetes/slider/slider.module';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-post',
  standalone: true,
  imports: [
    CommonModule,
    HeaderComponent,
    SliderModule,
    FooterComponent,
    FormsModule
  ],
  templateUrl: './post.component.html',
  styleUrl: './post.component.css'
})
export class PostComponent {
  likeCount = 0;
  showComments = false;
  newComment = ''; // Variable para almacenar el nuevo comentario
  comments: string[] = [ // Array para almacenar los comentarios
    '¡Excelente artículo! Es crucial concienciar sobre este tema.',
    'Muy informativo. Necesitamos actuar ahora para proteger nuestros bosques.'
  ];

  likeArticle() {
    this.likeCount++;
  }

  toggleComments() {
    this.showComments = !this.showComments;
  }

  addComment() {
    if (this.newComment.trim() !== '') {
      this.comments.push(this.newComment); // Agregar el nuevo comentario al array
      this.newComment = ''; // Limpiar el campo de comentario
    }
  }
}
