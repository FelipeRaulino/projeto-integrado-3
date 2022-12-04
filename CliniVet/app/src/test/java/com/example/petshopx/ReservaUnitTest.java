package com.example.petshopx;

import static org.junit.Assert.assertEquals;

import com.example.petshopx.model.Reserva;

import org.junit.Before;
import org.junit.Test;

public class ReservaUnitTest {

    Reserva reserva;

    @Before
    public void setUp(){
        reserva = new Reserva("9b89b52aa72ffba80d0315d6deb34357d48caf5d", "bc5d47bde5b4640cd64e10ffc716dff878b41b33", "9fbcd8657be5716a3017d3a2b3e2235c5c959bad", "485d4c4db2d6e90318a6d906648ef993fac1e2d8", "Bolt", "João", "Banho e tosa", "882937173828", "https://imgdopet.com/01", "10", "14:00", "Pendente");
    }

    @Test
    public void testAtualizandoNomeDoPet(){
        String nomePetTest = "Tuta";
        reserva.setPetNome(nomePetTest);
        assertEquals(nomePetTest, reserva.getPetNome());
    }

    @Test
    public void testAtualizandoServicoDaReserva(){
        String idServicoTest = "RRyx1Ldobf78VZp97QmF";
        reserva.setIdServico(idServicoTest);
        assertEquals(idServicoTest, reserva.getIdServico());
    }

    @Test
    public void testAtualizandoImagemDoPet(){
        String urlDaImagemDoPetTest = "https://nova_imagem_do_pet.com/01.png";
        reserva.setImgPet(urlDaImagemDoPetTest);
        assertEquals(urlDaImagemDoPetTest, reserva.getImgPet());
    }

    @Test
    public void testAtualizandoDiaDaReserva(){
        String diaTest = "18";
        reserva.setDia(diaTest);
        assertEquals(diaTest, reserva.getDia());
    }

    @Test
    public void testAtualizandoHorarioDaReserva(){
        String horarioTest = "15:30";
        reserva.setHora(horarioTest);
        assertEquals(horarioTest, reserva.getHora());
    }

    @Test
    public void testAtualizandoStatusDaReserva(){
        String statusTest = "Concluída";
        reserva.setStatus(statusTest);
        assertEquals(statusTest, reserva.getStatus());
    }


}
