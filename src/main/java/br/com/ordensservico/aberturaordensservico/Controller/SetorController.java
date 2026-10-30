package br.com.ordensservico.aberturaordensservico.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordensservico.aberturaordensservico.Service.SetorService;
import br.com.ordensservico.aberturaordensservico.model.Setor;
import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/setores")
public class SetorController {
    private final SetorService setorService;

    public SetorController(SetorService setorService){
        this.setorService = setorService;
    }
    @PostMapping 
    public ResponseEntity<Setor> cadastrar(@Valid @RequestBody Setor Setor){
        Setor setorCadastrado = setorService.cadastrar(Setor);

        return ResponseEntity.status(HttpStatus.CREATED).body(setorCadastrado);
    }
    @GetMapping
    public ResponseEntity<List<Setor>> listar(){
        List<Setor> setores = setorService.listar();
        return ResponseEntity.ok(setores);  
    }
      @GetMapping("/{id}")
    public ResponseEntity<Setor> buscarPorId(
            @PathVariable Integer id) {

        Optional<Setor> aluno = setorService.buscarPorId(id);
        if (aluno.isPresent()) {
            return ResponseEntity.ok(aluno.get());
        }
        return ResponseEntity.notFound().build();
    }
      @PutMapping("/{id}") 
    public ResponseEntity<Setor> atualizar(
            @Valid
            @PathVariable Integer id,
            @RequestBody Setor novosDados) {
        Optional<Setor> alunoAtualizado = setorService.atualizar(id, novosDados);

        if (alunoAtualizado.isPresent()) {
            return ResponseEntity.ok(alunoAtualizado.get());
        }

        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Integer id) {

        boolean excluido = setorService.excluir(id);

        if (excluido) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}