import java.util.List;


public class Application {

    public static void main(String[] args) {

        ServicoConsulta servicoConsulta = new ServicoConsulta();

        List<String> resultado = servicoConsulta.consultarDados();

        System.out.println(resultado);
    }

}
