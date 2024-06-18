import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FieldUser } from './field-user';

@Injectable({
  providedIn: 'root'
})

export class ServiceregistroserviceService {

  private apiUrl = 'http:localhost:8080/usuarios'; // Reemplaza con la URL correcta de tu API

  constructor(private http: HttpClient) { }

  registrarUsuario(user: FieldUser): Observable<FieldUser> {
    return this.http.post<FieldUser>(this.apiUrl, user);
  }
}



