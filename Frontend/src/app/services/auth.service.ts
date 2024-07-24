import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map, Observable, of } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth';
  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<boolean> {
    return this.http.post<{ jwt: string }>(`${this.apiUrl}/login`, { username, password }).pipe(
      tap(response => { sessionStorage.setItem('jwt', response.jwt) }),
      map(() => true),
      catchError(error => {
        console.log('Login error: ', error);
        return of(false);
      })
    );
  }

  checkAuthenticationStatus(): Observable<boolean> {
    const jwt = sessionStorage.getItem('jwt');
    return of(!!jwt);
  }

  logout(): void {
    sessionStorage.removeItem('jwt');
  }

  getJwtToken(): string | null {
    return sessionStorage.getItem('jwt');
  }

  resetPassword(email: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/reset-password`, { email });
  }

  confirmResetPassword(token: string | null, newPassword: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/reset-password/confirm`, { token, newPassword });
  }


}
