import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VendaRequestDTO, VendaResponseDTO } from '../models/venda.dto';

@Injectable({
  providedIn: 'root'
})
export class VendaService {

  private apiUrl = 'http://localhost:8080/api/vendas';

  constructor(private http: HttpClient) { }

  registrarVenda(venda: VendaRequestDTO): Observable<VendaResponseDTO> {
    return this.http.post<VendaResponseDTO>(this.apiUrl, venda);
  }
}