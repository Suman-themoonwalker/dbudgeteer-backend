package dwaki.dbudgeteer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import dwaki.dbudgeteer.service.GoogleSheetsService;

@Configuration
@SpringBootApplication
public class DbudgeteerApplication {

	private static GoogleSheetsService service;

	@Autowired
	public void getService(GoogleSheetsService service) {
		DbudgeteerApplication.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(DbudgeteerApplication.class, args);

	}

}
