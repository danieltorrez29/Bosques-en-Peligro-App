import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ServeceRegistroService } from './serveceRegistro.service';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})

export class RegistroComponent implements OnInit{
  
  

  nombreCompleto: String = "";
  telefono: number = 0;
  correo: String = "";
  contrasena: String = "";


  
  ngOnInit(): void {
    throw new Error('Method not implemented.');
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
