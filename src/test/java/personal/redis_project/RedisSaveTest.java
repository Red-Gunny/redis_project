package personal.redis_project;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisSaveTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void 레디스데이터삽입테스트() {

        // Arange
        String key = "testString";
        ValueOperations<String, String> stringStringValueOperations =
                redisTemplate.opsForValue();
        stringStringValueOperations.set(key, "1");

        // Act
        String fetchedValue = stringStringValueOperations.get(key);

        // Assertions
        System.out.println(fetchedValue);
        Assertions.assertThat(fetchedValue).isEqualTo("1");
    }

}
