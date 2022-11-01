package qualidade.br.com.qs.models;

public class CPF {
    String cpf;

    public CPF(String cpf) {
        this.cpf = cpf;
    }

    public boolean validaCPF() {
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11)) {
            return false;
        }

        int dig1, dig2, mod, digCpf;
        String resultado;

        dig1 = dig2 = 0;

        for (int i = 1; i < cpf.length() - 1; i++) {
        	digCpf = Integer.parseInt(cpf.substring(i - 1, i));
            dig1 += (11 - i) * digCpf;
            dig2 += (12 - i) * digCpf;
        }

        mod = (dig1 % 11);

        if (mod < 2) {
            dig1 = 0;
        } else {
            dig1 = 11 - mod;
        }

        dig2 += 2 * dig1;

        mod = (dig2 % 11);

        if (mod < 2) {
            dig2 = 0;
        } else {
            dig2 = 11 - mod;
        }

        String digitorVerificador = cpf.substring(cpf.length() - 2, cpf.length());

        resultado = String.valueOf(dig1) + String.valueOf(dig2);

        if (digitorVerificador.equals(resultado)) {
            return true;
        } else {
            return false;
        }
    }
}
