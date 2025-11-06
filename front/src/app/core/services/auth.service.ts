import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap, BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080';
  private currentUserSubject: BehaviorSubject<any | null>;
  public currentUser: Observable<any | null>;

  constructor(private http: HttpClient, private router: Router) {
    const userData = localStorage.getItem('usuario_logado');
    this.currentUserSubject = new BehaviorSubject<any | null>(userData ? JSON.parse(userData) : null);
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get getLoggedUser(): any | null {
    return this.currentUserSubject.value;
  }

  login(credentials: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, credentials).pipe(
      tap(response => {
        this.armazenarSessao(response);
        this.currentUserSubject.next(response); 
      })
    );
  }

  private armazenarSessao(sessionData: any): void {
    localStorage.setItem('usuario_logado', JSON.stringify(sessionData));
  }

  logout(): void {
    localStorage.removeItem('usuario_logado');
    this.currentUserSubject.next(null);
    this.router.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    return !!this.getLoggedUser;
  }

  getUserRole(): string | null {
    const user = this.getLoggedUser;
    return user ? (user.role || user.perfil) : null;
  }

  public updateLoggedUser(newUserData: any): void {
    
    this.armazenarSessao(newUserData);
    this.currentUserSubject.next(newUserData);
  }
}