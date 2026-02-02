package com.example.gestionapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*; // Importa esto
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    @Column(nullable = false)
    @NotBlank(message = "El nombre del producto es obligatorio") 

    private String producto;

    @Column(nullable = false)
    @NotBlank(message = "Debes seleccionar una categoría de la lista")
    private String categoria;

    @Column(name = "precio_unitario", nullable = false)
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio no puede ser negativo ni cero") //
    private Double precioUnitario;

    @Column(nullable = false)
    @NotNull(message = "Indica la cantidad")
    @Min(value = 1, message = "La cantidad mínima es 1")
    private Integer cantidad;

    @Column(name = "fecha_pedido", nullable = false)
    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fechaPedido;

    public Double getImporteTotal() {
        if (precioUnitario != null && cantidad != null) {
            return precioUnitario * cantidad;
        }
        return 0.0;
    }
    
    public Long getId_pedido() { return id_pedido; }
    public void setId_pedido(Long id_pedido) { this.id_pedido = id_pedido; }
    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido; }
}