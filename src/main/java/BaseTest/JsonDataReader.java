package BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {

	public static List<HashMap<String, String>> getjsonData( String filepath) throws Exception {
		String jasoncontent = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);

		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=	mapper.readValue(jasoncontent, new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;
	}

	public List<HashMap<String, String>> name(String filename) throws IOException {

		String jensomnfilecontent = FileUtils.readFileToString(new File(filename) ,StandardCharsets.UTF_8);

		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jensomnfilecontent, new TypeReference<List<HashMap<String, String>>>() {
		});

		return data;
	}

}
