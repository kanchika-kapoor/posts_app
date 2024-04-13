package com.hoaxify.hoaxify;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.hoaxify.hoaxify.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {
//    naming schema: methodName_condition_expectedBehaviour

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void postUser_userIsValid_receiveOk(){
        User user = new User();
        user.setUserName("test-user");
        user.setDisplayName("test-user");
        user.setPassword("Pas$word");

        ResponseEntity<Object> response = testRestTemplate.postForEntity("/api/1.0/users",user, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}