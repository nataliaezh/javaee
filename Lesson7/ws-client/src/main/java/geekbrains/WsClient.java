package geekbrains;

import java.net.MalformedURLException;
import java.net.URL;


public class WsClient {
    public static void main(String[] args) throws MalformedURLException {
    URL url = new URL("http://localhost:8080/les6/ProductService/ProductRepositoryImpl?wsdl");
    ProductService productService = new ProductService(url);
    ProductRepositoryWs productRepositoryImplPort=productService.getProductRepositoryImplPort();

    productRepositoryImplPort.findAll()
            .forEach(p-> System.out.println(p.getName()));
    }
}
