package br.com.ordensservico.aberturaordensservico.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.com.ordensservico.aberturaordensservico.model.Setor;

import br.com.ordensservico.aberturaordensservico.Repository.SetorRepository;
import br.com.ordensservico.aberturaordensservico.Dto.EquipamentoRequest;
import br.com.ordensservico.aberturaordensservico.Repository.EquipamentosRepository;
import br.com.ordensservico.aberturaordensservico.model.Equipamentos;

@Service 
public class EquipamentosService {
    private EquipamentosRepository equipamentosRepository;
    private SetorRepository setorRepository;


    public EquipamentosService(EquipamentosRepository equipamentosRepository, SetorRepository setorRepository) {
        this.equipamentosRepository = equipamentosRepository;
        this.setorRepository = setorRepository;
    }
    
    public Optional <Equipamentos> cadastrar(EquipamentoRequest dadosDquipamentos) {
        Optional<Setor> setorEncontrado = setorRepository.findById(dadosDquipamentos.getSetorId());
        
        if(setorEncontrado.isEmpty()){
            return Optional.empty();
        }
        Equipamentos equipamentos = new Equipamentos();
        equipamentos.setNome(dadosDquipamentos.getNome());
        equipamentos.setNumeroPatrimonio(dadosDquipamentos.getNumeroPatrimonio());
        equipamentos.setSetor(setorEncontrado.get());
        return Optional.of(equipamentosRepository.save(equipamentos));
    }
    public List<Equipamentos> listar(){
        return equipamentosRepository.findAll();
    }
    public Optional<Equipamentos> buscarPorId(Integer Id){
        return equipamentosRepository.findById(Id);
    }
    public Optional<Equipamentos> atualizar(Integer id, EquipamentoRequest novosDados) {
    Optional<Equipamentos> equipamentoExistente = equipamentosRepository.findById(id);
    
    if (equipamentoExistente.isEmpty()) {
        return Optional.empty();
    }
    
    Optional<Setor> setorEncontrado = setorRepository.findById(novosDados.getSetorId());

    if(setorEncontrado.isEmpty()){
        return Optional.empty();
    }

    Equipamentos equipamento = equipamentoExistente.get();
    
    equipamento.setNome(novosDados.getNome());
    equipamento.setNumeroPatrimonio(novosDados.getNumeroPatrimonio());
    equipamento.setSetor(setorEncontrado.get());
    
    return Optional.of(equipamentosRepository.save(equipamento));
    }
    public boolean excluir(Integer Id){
        if(!equipamentosRepository.existsById(Id)){
            return false;
        }
            equipamentosRepository.deleteById(Id);
            return true;
    }
}