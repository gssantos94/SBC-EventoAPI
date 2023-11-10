package com.devweb.sbceventoapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.devweb.sbceventoapi.model.Usuario;
import com.devweb.sbceventoapi.repository.UsuarioRepository;

@SpringBootTest
class SbcEventoApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@DataJpaTest
	public class UsuarioRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void whenFindById_thenReturnUsuario() {
        // given
        Usuario usuario = new Usuario("login", "email@test.com", "nome", "afiliacao", false);

        entityManager.persist(usuario);
        entityManager.flush();

        // when
        Usuario found = usuarioRepository.findById(usuario.getId()).orElse(null);

        // then
        assertThat(found.getLogin()).isEqualTo(usuario.getLogin());
    }
}
}

