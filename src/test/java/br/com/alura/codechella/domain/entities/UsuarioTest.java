//package br.com.alura.codechella.domain.entities;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//
//class UsuarioTest {
//    @Test
//    public void naoDeveCadastrarUsuarioComCpfInvalido() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            new Usuario("12345678", "Fulano", LocalDate.parse("2002-06-15"), "fulano@gmail.com");
//        });
//    }
//
//    @Test
//    public void deveCadastrarUsuarioComCpfValido() {
//        Usuario usuario = new Usuario("123.456.789-01", "Fulano", LocalDate.parse("2002-06-15"), "fulano@gmail.com");
//        Assertions.assertTrue(true, usuario.getCpf());
//    }
//
//    @Test
//    public void naoDeveCadastrarUsuarioComNomeVazio() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            new Usuario("123.456.789-01", "", LocalDate.parse("2002-06-15"), "fulano@gmail.com");
//        });
//    }
//
//    @Test
//    public void naoDeveCadastrarUsuarioComDataNascimentoInvalida() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            new Usuario("123.456.789-01", "Fulano", LocalDate.parse("2025-06-15"), "fulano@gmail.com");
//        });
//    }
//
//    @Test
//    public void naoDeveCadastrarUsuarioComEmailInvalido() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            new Usuario("123.456.789-01", "Fulano", LocalDate.parse("2002-06-15"), "fulanogmail.com");
//        });
//    }
//
//    @Test
//    public void deveCriarUsuarioUsandoAFabricaDeUsuarios() {
//        FabricaDeUsuario fabrica = new FabricaDeUsuario();
//        Usuario usuario = fabrica.comNomeCpfNascimento(
//                "123.456.789-01", "Fulano", LocalDate.parse("2002-06-15"), "fulano@gmail.com"
//        );
//
//        Assertions.assertEquals("Fulano", usuario.getNome());
//
//        usuario = fabrica.incluiEndereco("012345-0", 12, "Apt. 12");
//        Assertions.assertEquals("012345-0", usuario.getEndereco().getCep());
//    }
//}