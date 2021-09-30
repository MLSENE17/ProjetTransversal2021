import { Injectable } from '@angular/core';
import {IProg} from './listeModel'
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ListeService {
  private readonly API_URL = 'api/progression.json'
  constructor(private http: HttpClient) { }

  public getdemande(): Observable<IProg[]> {
    return this.http.get<IProg[]>(this.API_URL).pipe(
      tap(MaListe => console.log('MaListe: ', MaListe)),
      catchError(this.handleHttpError)
    );
  }
  private handleHttpError(err: HttpErrorResponse) {
    if (err.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', err.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${err.status}, ` +
        `body was: ${err.error}`);
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }
}

