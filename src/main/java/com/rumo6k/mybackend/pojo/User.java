package com.rumo6k.mybackend.pojo;

import java.util.List;

public class User {
  private String nome;
  private Integer idade;
  private Boolean active;
  private List<String> cards;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public List<String> getCards() {
    return cards;
  }

  public void setCards(List<String> cards) {
    this.cards = cards;
  }
}
