package freameworks.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToHashMap {

	public List<HashMap<String, String>> getHashMap(String path) throws IOException {
		
		String jsonContent= FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
		
		ObjectMapper mapper=new ObjectMapper(); // Jackson databind
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
	}
}
