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

import br.com.ordensservico.aberturaordensservico.Service.EquipamentosService;
import br.com.ordensservico.aberturaordensservico.model.Equipamentos;
import jakarta.validation.Valid;
@RestController 
@RequestMapping ("/equipamentos")
public class EquipamentosController {

    private final EquipamentosService equipamentosService;

    public EquipamentosController (EquipamentosService equipamentosService){
        this.equipamentosService = equipamentosService;
    }
     @PostMapping 
    public ResponseEntity<Equipamentos> cadastrar( @Valid @RequestBody Equipamentos equipamentos){
        Equipamentos equipamentoCadastrado = equipamentosService.cadastrar(equipamentos);

        return ResponseEntity.status(HttpStatus.CREATED).body(equipamentoCadastrado);

    }
    @GetMapping
    public ResponseEntity<List<Equipamentos>> listar() {
        List<Equipamentos> equipamentos = equipamentosService.listar();
        return ResponseEntity.ok(equipamentos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Equipamentos> buscarPorId(
            @PathVariable Integer id) {

        Optional<Equipamentos> equipamentos = equipamentosService.buscarPorId(id);
        if (equipamentos.isPresent()) {
            return ResponseEntity.ok(equipamentos.get());
        }

        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}") 
    public ResponseEntity<Equipamentos> atualizar(
            @Valid
            @PathVariable Integer id,
            @RequestBody Equipamentos novosDados) {
        Optional<Equipamentos> equipamentosAtualizado = equipamentosService.atualizar(id, novosDados);

        if (equipamentosAtualizado.isPresent()) {
            return ResponseEntity.ok(equipamentosAtualizado.get());
        }

        return ResponseEntity.notFound().build();
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Integer id) {

        boolean excluido = equipamentosService.excluir(id);

        if (excluido) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}