package com.rumo6k.mybackend.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Endereco {

  private String rua;
  private String minhaCidade;
  private String estado;
  private String pais;

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getMinhaCidade() {
    return minhaCidade;
  }

  public void setCidade(String minhaCidade) {
    this.minhaCidade = minhaCidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }
}
