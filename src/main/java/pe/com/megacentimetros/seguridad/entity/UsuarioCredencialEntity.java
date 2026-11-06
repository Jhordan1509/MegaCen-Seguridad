package pe.com.megacentimetros.seguridad.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "UsuarioCredencialEntity")
@Table(name = "usuariocredencial")
public class UsuarioCredencialEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codusu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomusu", length = 80, nullable = false, unique = true)
    private String nombreUsuario;

    @Column(name = "correo", length = 120, nullable = false, unique = true)
    private String correo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "clavehash", length = 255, nullable = false)
    private String clave;

    @Column(name = "feccre", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "ultacc")
    private LocalDateTime ultimoAcceso;

    @Column(name = "codper")
    private Long codper;

    @Column(name = "codrol", nullable = false)
    private Long codrol;

    @Column(name = "estusu", nullable = false)
    private Boolean estado;

    @Transient
    private Object personal;

    @Transient
    private Object rolsistema;
}
