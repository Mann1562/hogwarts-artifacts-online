package edu.tcu.cs.hogwartsartificatsonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.tcu.cs.hogwartsartificatsonline.artifact.utils.IdWorker;

@SpringBootApplication
public class HogwartsArtificatsOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(HogwartsArtificatsOnlineApplication.class, args);
	}

	public IdWorker idWorker() {
		return new IdWorker(1, 1);
	}

}
 