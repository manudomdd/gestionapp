package com.example.gestionapp.controller;

import com.example.gestionapp.model.Pedido;
import com.example.gestionapp.service.PedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PedidoWebController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/nuevo-pedido")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "formulario_pedido"; 
    }

    @PostMapping("/guardar-pedido")
    public String guardarPedido(@ModelAttribute Pedido pedido) {
        pedidoService.guardar(pedido);
        return "redirect:/nuevo-pedido?exito";
    }
    
    @GetMapping("/ver-pedidos")
    public String verListaPedidos(Model model, @RequestParam(required = false) String categoria) {
        List<Pedido> pedidos;
        
        if (categoria != null && !categoria.isEmpty()) {
            pedidos = pedidoService.listarPorCategoria(categoria);
        } else {
            pedidos = pedidoService.listarTodos();
        }
        model.addAttribute("listaPedidos", pedidos);
        model.addAttribute("categoriaSeleccionada", categoria);
        
        return "listado_pedidos"; 
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminar(id);
        return "redirect:/ver-pedidos";
    }

    @PostMapping("/eliminar-varios")
    public String eliminarVarios(@RequestParam(required = false) List<Long> ids) {
        if (ids != null && !ids.isEmpty()) {
            pedidoService.eliminarVarios(ids);
        }
        return "redirect:/ver-pedidos";
    }
}