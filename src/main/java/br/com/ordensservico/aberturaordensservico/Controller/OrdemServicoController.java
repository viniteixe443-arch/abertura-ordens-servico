package br.com.ordensservico.aberturaordensservico.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordensservico.aberturaordensservico.Dto.OrdemServicoRequest;
import br.com.ordensservico.aberturaordensservico.Service.OrdemServicoService;
import br.com.ordensservico.aberturaordensservico.model.OrdensServico;
import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/ordens-servico")
public class OrdemServicoController {
    private final OrdemServicoService ordemServicoService;

    public OrdemServicoController(OrdemServicoService ordemServicoService){
        this.ordemServicoService = ordemServicoService;
    }
    @PostMapping 
    public ResponseEntity<OrdensServico> cadastrar(@Valid @RequestBody 
        OrdemServicoRequest ordemServicoRequest){
            Optional<OrdensServico> ordemServicoCadastrada = 
            ordemServicoService.cadastrar(ordemServicoRequest);

        if(ordemServicoCadastrada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(ordemServicoCadastrada.get());

    }
    @GetMapping 
    public ResponseEntity <List<OrdensServico>> listar(){
        List <OrdensServico> ordensServicos = ordemServicoService.listar();
        return ResponseEntity.ok(ordensServicos);
    } 


    @GetMapping ("/{id}")
    public ResponseEntity <OrdensServico> listarPorId(@PathVariable Integer id){
        Optional<OrdensServico> ordemServico = ordemServicoService.listarPorId(id);
        if(ordemServico.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ordemServico.get());
    }
}
