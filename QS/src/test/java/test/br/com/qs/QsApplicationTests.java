package test.br.com.qs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QsApplicationTests {

	@Test
    void testSoma() {
        int soma= 1+1;
        assertEquals(2,soma);
    }


}
