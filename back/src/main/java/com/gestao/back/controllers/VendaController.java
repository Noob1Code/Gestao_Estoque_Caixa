/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestao.back.controllers;

import com.gestao.back.dto.VendaRequestDTO;
import com.gestao.back.dto.VendaResponseDTO;
import com.gestao.back.service.VendaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kayqu
 */

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin(origins = "http://localhost:4200")
public class VendaController {

    @Autowired
    private VendaServiceImpl vendaService; 

    @PostMapping
    public ResponseEntity<VendaResponseDTO> registrarVenda(
            @Valid @RequestBody VendaRequestDTO dto
    ) {
        VendaResponseDTO response = vendaService.registrarVenda(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
