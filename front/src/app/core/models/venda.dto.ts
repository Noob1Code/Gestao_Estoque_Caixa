import { ProdutoResponseDTO } from './produto.dto';

export interface ItemVenda {
  produto: ProdutoResponseDTO;
  quantidade: number;
  precoUnitario: number;
  subtotal: number;
}

export interface ItemVendaRequestDTO {
  produtoId: number;
  quantidade: number;
  precoUnitario: number; // Preço no momento da venda
}

export interface VendaRequestDTO {
  usuarioId: number;
  itens: ItemVendaRequestDTO[];
  valorRecebido: number;
  total: number;
}

export interface ItemVendaResponseDTO {
  id: number;
  produtoNome: string; 
  quantidade: number;
  precoUnitario: number;
  subtotal: number;
}

export interface VendaResponseDTO {
  id: number;
  dataVenda: string;
  nomeCliente?: string;
  total: number;
  valorRecebido: number;
  troco: number;
  itens: ItemVendaResponseDTO[]; 
}