package com.example.gestionapp.repository;

import com.example.gestionapp.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository <Pedido, Long>{
    
    List<Pedido> findByCategoria(String categoria); 
    
    
}
