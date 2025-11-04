import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient, private router: Router) { }

  login(credentials: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, credentials).pipe(
      tap(response => {
        this.armazenarSessao(response);
      })
    );
  }

  private armazenarSessao(sessionData: any): void {
    localStorage.setItem('usuario_logado', JSON.stringify(sessionData));
  }

  logout(): void {
    localStorage.removeItem('usuario_logado');
    this.router.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('usuario_logado');
  }

  // Obtém os dados do usuário logado.
  getLoggedUser(): any | null {
    const userData = localStorage.getItem('usuario_logado');
    if (userData) {
      return JSON.parse(userData);
    }
    return null;
  }
// O backend retorna 'ADMIN' ou 'OPERADOR', depende do GC
  getUserRole(): string | null {
    const user = this.getLoggedUser();
    // depende do GC 'role' ou 'perfil' (ajuste conforme o macaco)
    return user ? (user.role || user.perfil) : null;
  }
}