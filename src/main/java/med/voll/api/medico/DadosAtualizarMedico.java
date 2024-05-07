package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.Endereco;

public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        Especialidade especialidade,
        Endereco endereco) {

}
