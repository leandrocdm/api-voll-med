package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @Email
        String email,
        @NotBlank
        String telefone,
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @AssertTrue
        Boolean ativo,
        @NotNull @Valid DadosEndereco endereco) {
}
