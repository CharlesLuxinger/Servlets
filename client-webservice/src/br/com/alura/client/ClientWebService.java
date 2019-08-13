package br.com.alura.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class ClientWebService {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String result = Request.Post("http://localhost:8080/gerenciador/empresas")
				.addHeader("accept", "application/xml")
				.execute()
				.returnContent()
				.asString();
		
		System.out.println(result);
	}
}
