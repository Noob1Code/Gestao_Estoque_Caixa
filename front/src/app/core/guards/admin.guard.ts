import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { MessageService } from 'primeng/api';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(
    private authService: AuthService,
    private router: Router,
    private messageService: MessageService
  ) {}

  canActivate(): boolean {
    const userRole = this.authService.getUserRole();

    // Verifica se o perfil (role) é ADMIN
    if (this.authService.isLoggedIn() && userRole === 'ADMIN') {
      return true; // É admin, pode acessar
    } else {
      // Não é admin (pode ser OPERADOR ou não logado)
      this.messageService.add({
        severity: 'error',
        summary: 'Acesso Negado',
        detail: 'Você não tem permissão para acessar esta página.'
      });
      
      // Redireciona para a página principal (ou 'não autorizado')
      this.router.navigate(['/']); 
      return false;
    }
  }
}