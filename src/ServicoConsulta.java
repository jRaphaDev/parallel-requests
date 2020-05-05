import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class ServicoConsulta {

    public List<String> consultarDados(){
        List<Callable<String>> list = getRequestsList();


        List<String> resultado = list.parallelStream()
                .map(callable -> {
                    try {
                        System.out.format("callable: %s [%s]\n", callable, Thread.currentThread().getName());
                        return callable.call();
                    } catch (Exception e) {

                        e.printStackTrace();
                        return "";
                    }
                })
                .collect(Collectors.toList());

        return resultado;
    }

    private List<Callable<String>> getRequestsList() {

        Callable<String> callable1 = () -> new PrimeiroProxyConsulta().doRequest();
        Callable<String> callable2 = () -> new SegundoProxyConsulta().doRequest();

        List<Callable<String>> list = Arrays.asList(callable1, callable2);

        return list;
    }
}
