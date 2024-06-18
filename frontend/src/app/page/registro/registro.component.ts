import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from '../../componetes/header/header.component';
import { FooterComponent } from '../../componetes/footer/footer.component';
import { FormsModule } from '@angular/forms';
import { ServiceregistroserviceService } from './ServeceRegistroService';



@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [
    CommonModule,
    HeaderComponent,
    FooterComponent,
    FormsModule, // Añadir FormsModule
  ],
  templateUrl: './registro.component.html', // Asegurarse del nombre correcto
  styleUrls: ['./registro.component.css'] // Corrección aquí
})


export class RegistroComponent implements OnInit {
  nombre_completo: String = "";
  telefono: number = 0;
  correo: String = "";
  contraseña: String = "";

  



  ngOnInit(): void {
    //throw new Error ("Methodo no implementdo");
    // Inicialización del componente
  }

  onSubmit(form: any) {
    if (form.valid) {
      alert("Formulario enviado correctamente");
      const registro = {
        nombreCompleto: form.value. nombreCompleto,
        telefono: form.value.telefono,
        correo: form.value.correo,
        contrasena: form.value.contrasena
      };
      
    } else {
      alert("Formulario inválido");
    }
  }
}
