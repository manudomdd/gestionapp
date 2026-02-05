package com.example.gestionapp.service;

import com.example.gestionapp.model.Pedido;
import com.example.gestionapp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public void guardar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
    
    public List<Pedido> listarPorCategoria(String categoria) {
        return pedidoRepository.findByCategoria(categoria);
    }

    public void eliminar(Long id) {
        pedidoRepository.deleteById(id);
    }

    public void eliminarVarios(List<Long> ids) {
        pedidoRepository.deleteAllById(ids);
    }
}