package br.com.ordensservico.aberturaordensservico.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.Repository.EquipamentosRepository;
import br.com.ordensservico.aberturaordensservico.model.Equipamentos;

@Service 
public class EquipamentosService {
    private EquipamentosRepository equipamentosRepository;

    public EquipamentosService(EquipamentosRepository equipamentosRepository) {
        this.equipamentosRepository = equipamentosRepository;
    }
    
    public Equipamentos cadastrar(Equipamentos Equipamentos) {
        return equipamentosRepository.save(Equipamentos);
    }
    public List<Equipamentos> listar(){
        return equipamentosRepository.findAll();
    }
    public Optional<Equipamentos> buscarPorId(Integer Id){
        return equipamentosRepository.findById(Id);
    }
    public Optional<Equipamentos> atualizar(Integer id, Equipamentos novosDados) {
    Optional<Equipamentos> equipamentoExistente = equipamentosRepository.findById(id);
    
    if (equipamentoExistente.isEmpty()) {
        return Optional.empty();
    }
    
    Equipamentos equipamento = equipamentoExistente.get();
    
    equipamento.setNome(novosDados.getNome());
    equipamento.setNumeroPatrimonio(novosDados.getNumeroPatrimonio());
    equipamento.setSetor(novosDados.getSetor());
    
    return Optional.of(equipamentosRepository.save(equipamento));
}
}