import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { VendaRequestDTO, VendaResponseDTO } from '../models/venda.dto';

@Injectable({
  providedIn: 'root'
})
export class VendaService {

  private apiUrl = 'http://localhost:8080/api/vendas';
  private http= inject( HttpClient);

  registrarVenda(venda: VendaRequestDTO): Observable<VendaResponseDTO> {
    return this.http.post<VendaResponseDTO>(this.apiUrl, venda);
  }
}