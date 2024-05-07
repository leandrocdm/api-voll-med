package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping("/listarCadastroCompleto")
    public List<Medico> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Medico> listarPorId(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    @GetMapping("/listar")
    public Page<DadosMedicos> listarMedico(@PageableDefault Pageable paginacao){
        //return repository.findAll().stream().map(DadosMedicos::new).toList();
        return repository.findByAtivoTrue(paginacao).map(DadosMedicos::new);
    }

    @Transactional
    @PutMapping("/atualizar")
    public void atualizar(@RequestBody @Valid DadosAtualizarMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizar(dados);
    }

    @Transactional
    @PutMapping("/desativar/{id}")
    public void desativar(@PathVariable("id") Long id){
        var medico = repository.getReferenceById(id);
        medico.desativar();
    }

    @Transactional
    @PutMapping("/ativar/{id}")
    public void ativar(@PathVariable("id") Long id){
        var medico = repository.getReferenceById(id);
        medico.ativar();
    }

    @Transactional
    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable("id") Long id){
        repository.deleteById(id);
    }
}

