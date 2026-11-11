package br.com.ordensservico.aberturaordensservico.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity 
@Table (name = "ordem_servico")
public class OrdensServico {
    

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank (message = "A descrição é obrigatória")
    private  String descricao;

    private LocalDate dataAbertura;

    private LocalDateTime dataEncerramento;

    @NotBlank (message = "Informe a solução realizada")
    private String solucao;

    @ManyToOne 
    @JoinColumn (name = "equipamento_id", nullable = false)
    private Equipamentos equipamento;

    public OrdensServico(){

    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Equipamentos getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamentos equipamento) {
        this.equipamento = equipamento;
    }
    public LocalDateTime getDataEncerramento() {
    return dataEncerramento;
}

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
    this.dataEncerramento = dataEncerramento;
}

    public String getSolucao() {
    return solucao;
}

    public void setSolucao(String solucao) {
    this.solucao = solucao;
}

}
