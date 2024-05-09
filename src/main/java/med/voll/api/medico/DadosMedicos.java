package med.voll.api.medico;

public record DadosMedicos(
        Long id,
        String nome,
        String crm,
        Boolean ativo,
        Especialidade especialidade
) {
     public DadosMedicos(Medico medico) {
         this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getAtivo(), medico.getEspecialidade());
     }
}

