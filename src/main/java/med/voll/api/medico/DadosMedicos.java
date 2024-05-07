package med.voll.api.medico;

public record DadosMedicos(
        Long id,
        String nome,
        String crm,
        Especialidade especialidade
) {
     public DadosMedicos(Medico medico) {
         this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade());
     }
}

