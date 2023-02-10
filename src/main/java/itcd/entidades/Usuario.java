package itcd.entidades;

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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBUSUARIO")

public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TBUSUARIO")
	private  Long id;
	
	@Column(name = "MASP")
	private  String masp;
	
	@Column(name = "ID_LOCALIDADE")
	private  Long idLocalidade;
	
	@Column(name = "NM_USUARIO")
	private String numeroUsuario;
	
	@Column(name = "DS_EXERCICO_CARGO")
	private String descricaoExercicioCargo;
	
	@Column(name = "DT_INCLUSAO")
	private LocalDateTime  dataInclusao;

}
