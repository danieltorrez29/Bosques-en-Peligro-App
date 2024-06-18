import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FieldUser } from './field-user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServeceRegistroService {
  private apiUrl = 'http:localhost:8080/Usuario'; // Reemplaza con la URL correcta de tu API

  constructor(private http: HttpClient) { }

  registrarUsuario(user: FieldUser): Observable<FieldUser> {
    return this.http.post<FieldUser>(this.apiUrl, user);
  }
  
}
