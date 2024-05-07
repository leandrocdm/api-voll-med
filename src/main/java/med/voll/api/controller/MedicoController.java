package med.voll.api.controller;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosMedicos;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping("/listarTodasInfos")
    public List<Medico> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Medico> listarPorId(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    @GetMapping("/listar")
    public List<DadosMedicos> listarMedico(){
        return repository.findAll().stream().map(DadosMedicos::new).toList();

    }
}

