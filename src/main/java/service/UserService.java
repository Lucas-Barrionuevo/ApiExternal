package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	private final RestTemplate restTemplate;
	@Value("${spring.external.service.base-url}")
	private String basePath;
	public List<UserDto> getUsers(){
		UserDto response = restTemplate.getForObject(basePath + "/users", UserDto.class);
		return Arrays.asList(response);
	}
	public void saveUser(UserDto user) {
		restTemplate.postForObject(basePath + "/users", user, UserDto.class);
	}
	public void updateUser(int id, UserDto user) {
		restTemplate.put(basePath + "/users" + id, user);
	}
	public void deleteUser(int id) {
		restTemplate.delete(basePath + "/users" + id);
	}
}
