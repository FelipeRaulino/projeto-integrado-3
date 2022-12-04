package com.example.petshopx;

import static org.junit.Assert.assertEquals;

import com.example.petshopx.model.Pet;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnit4.class)
@PrepareForTest({FirebaseDatabase.class})
@PowerMockIgnore("jdk.internal.reflect.*")
public class PetUnitTest {
  private Pet pet;

  @Mock private DatabaseReference mockedDatabaseReference;

  @Before
  public void setUp() {
    mockedDatabaseReference = Mockito.mock(DatabaseReference.class);

    FirebaseDatabase mockedFirebaseDatabase = Mockito.mock(FirebaseDatabase.class);
    PowerMockito.when(mockedFirebaseDatabase.getReference()).thenReturn(mockedDatabaseReference);

    PowerMockito.mockStatic(FirebaseDatabase.class);
    PowerMockito.when(FirebaseDatabase.getInstance()).thenReturn(mockedFirebaseDatabase);

    pet =
        new Pet(
            "67477fed1789f17fa188337265ff245459776f2b",
            "Joao",
            "Cachorro",
            "Um cachorro bonito",
            "12",
            "6",
            "100",
            "https://urldaimagem.com/1");
  }

  @Test
  public void testSetId() {
    String idTest = "bdfdd26dbc92050810acf34d541f67b52ec6ec56";
    pet.setId(idTest);
    assertEquals(idTest, pet.getId());
  }

  @Test
  public void testSetNome() {
    String nomeTest = "Bolt";
    pet.setNome(nomeTest);
    assertEquals(nomeTest, pet.getNome());
  }

  @Test
  public void testAtualizandoTipoPet() {
    String tipoTest = "Bolt";
    pet.setTipo(tipoTest);
    assertEquals(tipoTest, pet.getTipo());
  }

  @Test
  public void testSetDescricao() {
    String descricaoTest = "Uma nova descrição";
    pet.setDescricao(descricaoTest);
    assertEquals(descricaoTest, pet.getDescricao());
  }

  @Test
  public void testSetIdade() {
    String idadeTest = "2,5";
    pet.setIdade(idadeTest);
    assertEquals(idadeTest, pet.getIdade());
  }

  @Test
  public void testSetPeso() {
    String pesoTest = "2,8";
    pet.setPeso(pesoTest);
    assertEquals(pesoTest, pet.getPeso());
  }

  @Test
  public void testSetAltura() {
    String alturaTest = "88";
    pet.setAltura(alturaTest);
    assertEquals(alturaTest, pet.getAltura());
  }
}
