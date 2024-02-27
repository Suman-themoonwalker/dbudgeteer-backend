package dwaki.dbudgeteer.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dwaki.dbudgeteer.service.GoogleSheetsService;

@RestController
public class DbudgeteerController {

	@Autowired
	private GoogleSheetsService service;

	@GetMapping(path = "/test")
	public void test() {

		System.out.println("TEST");

		final String spreadsheetId = "1GMYHwNHrFYrpwsmfaSX0UjlH-eZjppRsOyEMzIEfwXU";
		final String range = "Savings!B1:C11";

		try {
			service.getValues(spreadsheetId, range);
		} catch (IOException | GeneralSecurityException e) {

			e.printStackTrace();
		}

		System.out.println("Check");

	}

}
