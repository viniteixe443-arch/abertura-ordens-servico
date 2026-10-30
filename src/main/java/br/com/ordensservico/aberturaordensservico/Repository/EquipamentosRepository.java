package br.com.ordensservico.aberturaordensservico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ordensservico.aberturaordensservico.model.Equipamentos;

public interface EquipamentosRepository 
    extends JpaRepository<Equipamentos, Integer>{
    
}
