package dwaki.dbudgeteer.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import dwaki.dbudgeteer.config.GoogleSheetsConfig;

@Service
public class GoogleSheetsService {

	@Autowired
	public GoogleSheetsConfig config;

	public void getValues(String spreadsheetId, String range) throws IOException, GeneralSecurityException {

		Sheets sheets = config.getSheetsService();
		

		ValueRange response = sheets.spreadsheets().values().get(spreadsheetId, range).execute();
		List<List<Object>> values = response.getValues();

		for (List<Object> value : values)
			for (Object object : value)
				System.out.println(object.toString());

	}

}
