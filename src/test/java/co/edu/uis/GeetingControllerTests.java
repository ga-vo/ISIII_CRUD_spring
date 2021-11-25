package co.edu.uis;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GeetingControllerTests {

    @Mock
    private UsuarioRepository usuarioRepository;

    // @InjectMocks
    // private GeetingController geetingController = new GeetingController();

    private Usuario usuario1;
    private Usuario usuario2;
    private List<Usuario> usuarios;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        usuario1 = new Usuario("Gabriel", "ES");
        usuario2 = new Usuario("Felipe", "FR");
        usuarios = Arrays.asList(usuario1, usuario2);
    }

    @Test
    public void viewAll() {
        // view all length test
        final GreetingController gc = new GreetingController(usuarioRepository);
        when(usuarioRepository.findAll()).thenReturn(usuarios);
        assertTrue(gc.viewall("").size() == usuarios.size());
    }

    @Test
    public void view() {
        try {
            // view all length test
            final GreetingController gc = new GreetingController(usuarioRepository);
            // doReturn(us1).when(ur.findById(us1.getId()));
            when(usuarioRepository.findById(usuario1.getId())).thenReturn(Optional.of(usuario1));
            Usuario us;
            us = gc.view(usuario1.getId());
            assertTrue(us.getName().equals(usuario1.getName()));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteEmployee() {
        try {
            // view all length test
            final GreetingController gc = new GreetingController(usuarioRepository);
            // doReturn(us1).when(ur.findById(us1.getId()));
            when(usuarioRepository.findById(usuario1.getId())).thenReturn(Optional.of(usuario1));
            Usuario us;
            us = gc.deleteEmployee(usuario1.getId());
            assertTrue(us.getName().equals(usuario1.getName()));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateUser() {
        try {
            // view all length test
            final GreetingController gc = new GreetingController(usuarioRepository);
            // doReturn(us1).when(ur.findById(us1.getId()));
            when(usuarioRepository.findById(usuario1.getId())).thenReturn(Optional.of(usuario1));
            Usuario us;
            String newName = "Gabriel Felipe";
            us = gc.updateUser(usuario1.getId(), newName);
            assertTrue(us.getName().equals(newName));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void newUsuario() {
        try {
            Usuario nuevoUsuario = new Usuario("Duque", "FR");
            when(usuarioRepository.save(nuevoUsuario)).thenReturn(nuevoUsuario);
            final GreetingController gc = new GreetingController(usuarioRepository);
            Usuario us = gc.newUsuario(nuevoUsuario.getName(), nuevoUsuario.getLang());
            assertTrue(us.getName().equals(nuevoUsuario.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
