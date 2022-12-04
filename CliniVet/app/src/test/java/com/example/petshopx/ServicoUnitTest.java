package com.example.petshopx;

import static org.junit.Assert.assertEquals;

import com.example.petshopx.model.Servico;
import org.junit.Before;
import org.junit.Test;

public class ServicoUnitTest {

  Servico servico;

  @Before
  public void setUp() {
    servico =
        new Servico(
            "17Hj7enYG14s4W5AT1ZM1MyIP",
            "Vacinação",
            "Cachorros",
            "Serviço de vacinação em cachorros",
            "50");
  }

  @Test
  public void testAtualizandoNomeDeUmServico() {
    String nomeServicoTest = "Vacinação em filhotes";
    servico.setNome(nomeServicoTest);
    assertEquals(nomeServicoTest, servico.getNome());
  }

  @Test
  public void testAtualizandoPetsDestinadosDeUmServico() {
    String petsServicoTest = "Gatos";
    servico.setPets(petsServicoTest);
    assertEquals(petsServicoTest, servico.getPets());
  }

  @Test
  public void testAtualizandoDescricaoDeUmServico() {
    String descricaoServicoTest = "Vacinação em filhotes";
    servico.setDescricao(descricaoServicoTest);
    assertEquals(descricaoServicoTest, servico.getDescricao());
  }

  @Test
  public void testAtualizandoPrecoDeUmServico() {
    String precoServicoTest = "65";
    servico.setPreco(precoServicoTest);
    assertEquals(precoServicoTest, servico.getPreco());
  }
}
