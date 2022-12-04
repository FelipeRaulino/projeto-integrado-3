package com.example.petshopx;

import static org.junit.Assert.assertEquals;

import com.example.petshopx.model.Usuario;
import org.junit.Before;
import org.junit.Test;

public class UsuarioUnitTest {
  Usuario usuario;

  @Before
  public void setUp() {
    usuario = new Usuario();
  }

  @Test
  public void testSetId() {
    String idTest = "67477fed1789f17fa188337265ff245459776f2b";
    usuario.setId(idTest);
    assertEquals(idTest, usuario.getId());
  }

  @Test
  public void testSetNome() {
    String nomeTest = "João";
    usuario.setNome(nomeTest);
    assertEquals(nomeTest, usuario.getNome());
  }

  @Test
  public void testSetEmail() {
    String emailTest = "joão@gmail.com";
    usuario.setNome(emailTest);
    assertEquals(emailTest, usuario.getNome());
  }

  @Test
  public void testSetTelefone() {
    String telefoneTest = "88928373829";
    usuario.setNome(telefoneTest);
    assertEquals(telefoneTest, usuario.getNome());
  }

  @Test
  public void testSetSenha() {
    String senhaTest = "joao123";
    usuario.setNome(senhaTest);
    assertEquals(senhaTest, usuario.getNome());
  }
}
