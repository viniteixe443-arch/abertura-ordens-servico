package br.com.ordensservico.aberturaordensservico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
@Table (name =  "equipamentos")
public class Equipamentos {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank (message = "O nome é Obrigatório")
    private String nome;

    @NotBlank (message = "O número do equipamento é Obrigatório")
    private String numeroPatrimonio;

    @ManyToOne 
    @NotNull(message = "O setor é obrigatório")
    @JoinColumn (name = "setor_id", nullable = false)
    private Setor setor;

    public Equipamentos() {
    }

    public Equipamentos(String nome, String numeroPatrimonio, Setor setor) {
        this.nome = nome;
        this.numeroPatrimonio = numeroPatrimonio;
        this.setor = setor;
    }

  
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

}
