package br.com.ordensservico.aberturaordensservico.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.Dto.EncerramentoOrdemServicoRequest;
import br.com.ordensservico.aberturaordensservico.Dto.OrdemServicoRequest;
import br.com.ordensservico.aberturaordensservico.Repository.EquipamentosRepository;
import br.com.ordensservico.aberturaordensservico.Repository.OrdensServicoRepository;
import br.com.ordensservico.aberturaordensservico.model.Equipamentos;
import br.com.ordensservico.aberturaordensservico.model.OrdensServico;

@Service 
public class OrdemServicoService {
    private final OrdensServicoRepository ordensServicoRepository;
    private final EquipamentosRepository equipamentosRepository;

    public OrdemServicoService(OrdensServicoRepository ordensServicoRepository, EquipamentosRepository equipamentosRepository){
        this.ordensServicoRepository = ordensServicoRepository;
        this.equipamentosRepository = equipamentosRepository;
    }
    public Optional<OrdensServico> cadastrar(OrdemServicoRequest ordemServicoRequest){
        Optional<Equipamentos> equipamentoEncontrado = equipamentosRepository.findById(ordemServicoRequest.getEquipamentoId());

        if(equipamentoEncontrado.isEmpty()) {
            return Optional.empty();
        }
        OrdensServico ordensServico = new OrdensServico();

        ordensServico.setDescricao(ordemServicoRequest.getDescricao());
        ordensServico.setEquipamento(equipamentoEncontrado.get());
        ordensServico.setDataAbertura(LocalDate.now());
        OrdensServico ordemServicoCadastrada = ordensServicoRepository.save(ordensServico);
        return Optional.of(ordemServicoCadastrada);
    }
    public List<OrdensServico> listar(){
        return ordensServicoRepository.findAll();
    }
    public Optional<OrdensServico> listarPorId(Integer id){
        return ordensServicoRepository.findById(id);
    }
    public Optional<OrdensServico> encerrar(Integer id, EncerramentoOrdemServicoRequest encerramentoOrdemServicoRequest){
        Optional<OrdensServico> ordemServicoOptional = ordensServicoRepository.findById(id);
        if (ordemServicoOptional.isPresent()) {
            OrdensServico ordensServico = ordemServicoOptional.get();
            ordensServico.setSolucao(encerramentoOrdemServicoRequest.getSolucao());
            ordensServico.setDataEncerramento(LocalDateTime.now());
            ordensServicoRepository.save(ordensServico);
            return Optional.of(ordensServico); 
        }
        return Optional.empty();
    }
       public List<OrdensServico> listarOrdensEmAberto() {
        return ordensServicoRepository.findByDataEncerramentoIsNull();
    }
}
