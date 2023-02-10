package itcd.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioDTO {

	private String masp;
	private Long idLocalidade;
	private String numeroUsuario;
	private String descricaoExercicioCargo;
	private LocalDate dataInclusao;
	
}
