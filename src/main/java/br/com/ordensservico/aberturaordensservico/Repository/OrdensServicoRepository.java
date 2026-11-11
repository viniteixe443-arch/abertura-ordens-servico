package br.com.ordensservico.aberturaordensservico.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ordensservico.aberturaordensservico.model.OrdensServico;

@Repository 
public interface OrdensServicoRepository    
    extends JpaRepository<OrdensServico,Integer> {
    List<OrdensServico> findByDataEncerramentoIsNull();
}
