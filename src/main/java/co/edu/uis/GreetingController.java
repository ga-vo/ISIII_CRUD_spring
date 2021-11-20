package co.edu.uis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private final UsuarioRepository repository;

	private static final String template_fr = "Salut, %s!";
	private static final String template_ge = "Hallo, %s!";
	private static final String template_es = "Hola, %s!";
	private static final String template_en = "Hello, %s!";
	private static final String template_not = "%s is not registered :(";

	public GreetingController(UsuarioRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		List<Usuario> uss = repository.findByName(name);
		if (uss != null) {
			if (uss.size() < 1) {
				return new Greeting(counter.incrementAndGet(), String.format(template_not, name));
			}
		}
		Usuario us = repository.findByName(name).get(0);
		String la = us.getLang();
		if (la.equals("ES")) {
			return new Greeting(counter.incrementAndGet(), String.format(template_es, name));
		} else if (la.equals("EN")) {
			return new Greeting(counter.incrementAndGet(), String.format(template_en, name));
		} else if (la.equals("DE")) {
			return new Greeting(counter.incrementAndGet(), String.format(template_ge, name));
		} else if (la.equals("FR")) {
			return new Greeting(counter.incrementAndGet(), String.format(template_fr, name));
		} else {
			return new Greeting(counter.incrementAndGet(), String.format(template_en, name));
		}
	}

	@GetMapping("/view")
	public List<Usuario> view(@RequestParam(value = "name", defaultValue = "World") String name) {
		return repository.findByName(name);

	}

	@GetMapping("/viewall")
	public List<Usuario> viewall(@RequestParam(value = "name", defaultValue = "World") String name) {
		return repository.findAll();

	}

	@PatchMapping("user/{id}")
	public List<Usuario> updateUser(@PathVariable Long id, @RequestParam(value = "name", defaultValue = "") String name)  
	throws ResourceNotFoundException{
		Usuario us = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID necesario:" + id));

		if (!name.equals("")){
			us.setName(name);
			repository.save(us);
		}
		return repository.findByName(name);
	}

	@PostMapping("/register")
	Usuario newUsuario(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "lang", defaultValue = "EN") String lang) {
		return repository.save(new Usuario(name, lang));
	}

	@DeleteMapping("/delete")
	public Greeting deleteEmployee(@RequestParam(value = "name", defaultValue = "World") String name) {
		List<Usuario> uss = repository.findByName(name);

		if (uss != null) {
			if (uss.size() < 1) {
				return new Greeting(counter.incrementAndGet(), String.format(template_not, name));
			}
			Usuario us = uss.get(0);
			repository.deleteById(us.getId());
			return new Greeting(counter.incrementAndGet(), String.format("%s deleted!", name));
		}
		return new Greeting(counter.incrementAndGet(), String.format(template_not, name));

	}

}