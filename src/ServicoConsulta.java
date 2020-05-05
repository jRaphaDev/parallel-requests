import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServicoConsulta {

    public List<String> consultarDados(){

        Proxy proxyUm = new PrimeiroProxyConsulta();
        Proxy proxyDois = new SegundoProxyConsulta();

        List<String> resultado = Arrays.asList(proxyUm.doRequest(), proxyDois.doRequest())
                .parallelStream()
                .collect(Collectors.toList());

        return resultado;
    }
}
