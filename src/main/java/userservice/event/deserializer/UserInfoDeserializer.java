package userservice.event.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import userservice.model.UserInfoDto;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		Deserializer.super.configure(configs, isKey);
	}

	@Override
	public UserInfoDto deserialize(String s, byte[] bytes) {
		System.out.println("Called from UserInfoDeserializer");
		ObjectMapper objectMapper = new ObjectMapper();
		UserInfoDto user = null;
		try {
			user = objectMapper.readValue(bytes, UserInfoDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void close() {
		Deserializer.super.close();
	}
}
