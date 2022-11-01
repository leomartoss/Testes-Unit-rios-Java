package cpf.models;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class cpf {	

	@SpringBootTest
	public class CPFTests {

	    @Test
	    void validaCPF(){
	        cpf numeroCpf1 = new cpf();
	        Assertions.assertTrue(numeroCpf1.validaCPF());
	    }

	    @Test
	    void validaCPFinvalido(){
	        cpf numeroCpf2 = new cpf();
	        Assertions.assertFalse(numeroCpf2.validaCPF());
	    }
	}

	public BooleanSupplier validaCPF() {
		// TODO Auto-generated method stub
		return null;
	}


}
