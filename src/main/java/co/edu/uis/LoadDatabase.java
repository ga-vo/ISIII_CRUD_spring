package co.edu.uis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  
  public  LoadDatabase() {
	// TODO Auto-generated constructor stub
}
  @Bean
  CommandLineRunner initDatabase(UsuarioRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Usuario("Gabriel", "ES")));
      log.info("Preloading " + repository.save(new Usuario("Felipe", "FR")));
      log.info("Preloading " + repository.save(new Usuario("Petro", "EN")));
    };
  }
}