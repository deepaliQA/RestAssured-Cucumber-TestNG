package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	private static final ObjectMapper mapper = new ObjectMapper();

	// Convert Java object into JSON string
	public static String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Unable to serialize Java object to JSON", e);
		}
	}
// Convert JSON string into Java object

	public static <T> T fromJson(String json, Class<T> classType) throws JsonProcessingException {
		try {
			return mapper.readValue(json, classType);
		} catch (JsonMappingException e) {
			throw new RuntimeException("Unable to deserialize JSON into " + classType.getSimpleName(), e);
		}
	}
}
