import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { HeaderComponent } from '../../componetes/header/header.component';
import { FooterComponent } from '../../componetes/footer/footer.component';
import { FormsModule } from '@angular/forms';
import { ServiceregistroserviceService } from './ServeceRegistroService';


=======
import { FormsModule } from '@angular/forms';
import { ServeceRegistroService } from './serveceRegistro.service';
>>>>>>> 0bb3f7c053d0cfbd1facc6a70eebcd025f90da2b

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [
    CommonModule,
<<<<<<< HEAD
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
=======
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
>>>>>>> 0bb3f7c053d0cfbd1facc6a70eebcd025f90da2b
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
      
<<<<<<< HEAD
=======
      

>>>>>>> 0bb3f7c053d0cfbd1facc6a70eebcd025f90da2b
    } else {
      alert("Formulario inválido");
    }
  }
<<<<<<< HEAD
=======
   
>>>>>>> 0bb3f7c053d0cfbd1facc6a70eebcd025f90da2b
}
