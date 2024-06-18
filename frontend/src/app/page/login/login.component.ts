import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { HeaderComponent } from '../../componetes/header/header.component';
import { FooterComponent } from '../../componetes/footer/footer.component';
import { SliderComponent } from '../../componetes/slider/slider.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    HeaderComponent,
    FooterComponent,
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor() { }

  login() {
    // Aquí puedes implementar la lógica de autenticación
    console.log('Username:', this.username);
    console.log('Password:', this.password);

    // Ejemplo básico de validación de usuario y contraseña (¡No usar en producción!)
    if (this.username === 'usuario' && this.password === 'password') {
      alert('Inicio de sesión exitoso');
      // Aquí podrías redirigir a otra página después del login exitoso
    } else {
      alert('Usuario o contraseña incorrectos');
    }
  }

}
