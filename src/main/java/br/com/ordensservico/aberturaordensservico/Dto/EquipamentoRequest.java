package br.com.ordensservico.aberturaordensservico.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EquipamentoRequest {
    @NotBlank (message = "O nome é obrigatório")
    private String nome;

    @NotBlank (message = "O numero de patrimônio é obrigatório")
    private String numeroPatrimonio;

    @NotNull  (message = "O id é obrigatório")
    private Integer setorId;


    EquipamentoRequest(){

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

public Integer getSetorId() {
    return setorId;
}

}
