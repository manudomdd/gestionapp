package com.example.gestionapp.service;

import com.example.gestionapp.model.Pedido;
import com.example.gestionapp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // <--- ¡IMPORTANTE!
import java.util.List;

@Service // <--- ¡ESTO ES LO QUE TE FALTA! Sin esto, Spring no lo "ve".
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Método para guardar un pedido (lo usarás en el JDialog)
    public void guardar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    // Método para listar todos (lo usa tu JTable)
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
    
    public List<Pedido> listarPorCategoria(String categoria) {
        return pedidoRepository.findByCategoria(categoria);
    }
    
    // Eliminar un solo pedido por ID
    public void eliminar(Long id) {
        pedidoRepository.deleteById(id);
    }

    // Eliminar varios pedidos de golpe
    public void eliminarVarios(List<Long> ids) {
        // deleteAllById es un método mágico de JPA, muy eficiente
        pedidoRepository.deleteAllById(ids);
    }
}