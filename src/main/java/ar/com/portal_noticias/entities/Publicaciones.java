package ar.com.portal_noticias.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "publicaciones")
public class Publicaciones implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaPublicacion;
    @Column(columnDefinition = "TEXT")
    private String contenido;
    private String prioridad;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "fk_tema", referencedColumnName = "id")
    @JsonIgnore
    private Temas tema;

    // 👇 ESTO ES LO QUE HAY QUE CAMBIAR: List<PublicacionAutores> en vez de List<Autores>
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PublicacionAutores> autores;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Temas getTema() { return tema; }
    public void setTema(Temas tema) { this.tema = tema; }
    public List<PublicacionAutores> getAutores() { return autores; }
    public void setAutores(List<PublicacionAutores> autores) { this.autores = autores; }
}