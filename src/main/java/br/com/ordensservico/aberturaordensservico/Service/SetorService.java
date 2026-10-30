package br.com.ordensservico.aberturaordensservico.Service;

import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.Repository.SetorRepository;
import br.com.ordensservico.aberturaordensservico.model.Setor;

import java.util.List;
import java.util.Optional;
@Service 
public class SetorService {
    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository){
        this.setorRepository = setorRepository;
    }
     public Setor cadastrar(Setor setor) {
        return setorRepository.save(setor);
    }
    public List<Setor> listar(){
        return setorRepository.findAll();
    }
    public Optional<Setor> buscarPorId(Integer Id){
        return setorRepository.findById(Id);
    }
    public Optional<Setor> atualizar(Integer Id, Setor novosDados){
        Optional<Setor> setorExistente = setorRepository.findById(Id);
        if (setorExistente.isEmpty()){
            return Optional.empty();
        }
        Setor setor = setorExistente.get();
        setor.setNome(novosDados.getNome());
        return Optional.of(setorRepository.save(setor));
    }
    public boolean excluir(Integer Id){
     if(!setorRepository.existsById(Id)){
        return false;
     }
         setorRepository.deleteById(Id);
        return true;
    }
}
