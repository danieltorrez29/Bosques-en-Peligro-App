import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { ServeceRegistroService } from '../app/page/registro/serveceRegistro.service'// Ajusta la ruta si es diferente


import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes),
    ServeceRegistroService]
};
