package pe.com.megacentimetros.seguridad.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "AuditoriaLogEntity")
@Table(name = "auditorialog")
public class AuditoriaLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codaud")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "feceve", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "accion", length = 80, nullable = false)
    private String accion;

    @Column(name = "modulo", length = 80, nullable = false)
    private String modulo;

    @Column(name = "descrip", length = 500)
    private String descripcion;

    @Column(name = "dirip", length = 45)
    private String dirIp;

    @Column(name = "codusu")
    private Long codusu;

    @Column(name = "estaud", nullable = false)
    private Boolean estado;
}
