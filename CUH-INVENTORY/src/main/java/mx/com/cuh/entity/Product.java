package mx.com.cuh.entity;

import javax.persistence.*;


@Entity
@Table(name = "PRODUCTOS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_productos")
    @SequenceGenerator(name = "seq_productos",sequenceName = "seq_products",allocationSize = 1)
    @Column(name = "ID_PRODUCTO")
    private Long idProducto;

    @Column(name = "BARCODE")
    private String barCode;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "PRESENTACION")
    private String presentacion;

    @Column(name = "PROVEDOR")
    private String provedor;

    @Column(name = "CATEGORIA")
    private String categoria;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
