import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
import { AuthService } from '../../core/services/auth.service';

import { SidebarModule } from 'primeng/sidebar';
import { ButtonModule } from 'primeng/button';
import { ToolbarModule } from 'primeng/toolbar';
import { MenuModule } from 'primeng/menu';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-main-layout',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    RouterLink,
    SidebarModule,
    ButtonModule,
    ToolbarModule,
    MenuModule
  ],
  templateUrl: './main-layout.component.html',
  styleUrls: ['./main-layout.component.css']
})
export class MainLayoutComponent implements OnInit {

  sidebarVisible = false;
  menuItems: MenuItem[] = [];
  nomeUsuario: string = '';

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
    const usuario = this.authService.getLoggedUser();
    const perfil = this.authService.getUserRole();

    if (usuario) {
      this.nomeUsuario = usuario.nomeCompleto || 'Usuário';
    }

    this.carregarMenu(perfil);
  }

  private carregarMenu(perfil: string | null): void {
    const menu: MenuItem[] = [];

    // 1. Itens do ADMIN
    if (perfil === 'ADMIN') {
      menu.push({
        label: 'Administração',
        items: [
          {
            label: 'Gerenciar Usuários',
            icon: 'pi pi-users',
            routerLink: '/admin/usuarios'
          },
          {
            label: 'Gestão de Estoque',
            icon: 'pi pi-box',
            routerLink: '/admin/estoque'
          }
        ]
      });
    }

    // 2. Itens do OPERADOR
    if (perfil === 'OPERADOR') {
      menu.push({
        label: 'Operador',
        items: [
          {
            label: 'Caixa / Vendas',
            icon: 'pi pi-shopping-cart',
            routerLink: '/caixa'
          }
        ]
      });
    }

    menu.push({
      label: 'Geral',
      items: [
        {
          label: 'Relatórios',
          icon: 'pi pi-chart-bar',
          routerLink: '/relatorios'
        }
      ]
    });

    this.menuItems = menu;
  }

  logout(): void {
    this.authService.logout();
  }
}