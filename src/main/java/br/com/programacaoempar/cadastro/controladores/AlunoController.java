package br.com.programacaoempar.cadastro.controladores;

import br.com.programacaoempar.cadastro.entidades.Aluno;
import br.com.programacaoempar.cadastro.repositorios.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    public ResponseEntity<Aluno> salvaAluno(@RequestBody Aluno aluno){
        try {
            Aluno _aluno = repository.save(aluno);
            return new ResponseEntity<>(_aluno, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public Iterable<Aluno> obtemAlunos(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> obtemAluno(@PathVariable("id") Long id){
        Optional<Aluno> alunoData = repository.findById(id);
        if (alunoData.isPresent()) {
            return new ResponseEntity<>(alunoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> atualizaAluno(@PathVariable("id") Long id, @RequestBody Aluno alunoAtualizado){
        Optional<Aluno> aluno = repository.findById(id);
        if(aluno.isPresent()){
            Aluno _aluno = aluno.get();
            _aluno.setNome(alunoAtualizado.getNome());
            _aluno.setEmail(alunoAtualizado.getEmail());
            _aluno.setLinkedin(alunoAtualizado.getLinkedin());
            _aluno.setNascimento(alunoAtualizado.getNascimento());
            return new ResponseEntity<>(repository.save(_aluno), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> apagaAluno(@PathVariable("id") Long id){
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
