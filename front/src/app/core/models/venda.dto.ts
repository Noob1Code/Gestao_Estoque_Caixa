import { ProdutoResponseDTO } from './produto.dto';

/**
 * Interface para um item individual dentro do "carrinho"
 */
export interface ItemVenda {
  produto: ProdutoResponseDTO;
  quantidade: number;
  precoUnitario: number;
  subtotal: number;
}

/**
 * Interface para enviar um item ao backend
 */
export interface ItemVendaRequestDTO {
  produtoId: number;
  quantidade: number;
  precoUnitario: number; // Preço no momento da venda
}

/**
 * Interface para enviar a venda completa ao backend
 */
export interface VendaRequestDTO {
  usuarioId: number;
  itens: ItemVendaRequestDTO[];
  valorRecebido: number;
  total: number;
}

/**
 * (Opcional) O que o backend pode responder
 */
export interface VendaResponseDTO {
  id: number;
  dataVenda: string;
  nomeCliente?: string;
  total: number;
  valorRecebido: number;
  troco: number;
  itens: any[];
}