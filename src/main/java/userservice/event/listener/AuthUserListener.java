package userservice.event.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import userservice.model.UserInfoDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AuthUserListener {

	@KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
	public void listen(String message) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		UserInfoDto userInfo = mapper.readValue(message, UserInfoDto.class);
		System.out.println("Consumed user: " + userInfo);
	}
}
