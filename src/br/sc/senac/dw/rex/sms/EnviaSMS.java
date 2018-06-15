package br.sc.senac.dw.rex.sms;

public class EnviaSMS {

	public static void send(String numero, String msg) throws Exception{
		PapovaiHttpClientConnector papovaiHttpClientConnector = new PapovaiHttpClientConnector();
		
		String numbers = numero;
		String message = msg;
		String date = "2016-01-31 21:25";
		String startDate = "2016-01-25";
		String endDate = "2016-01-31";
		String ids = "1;2;3;45";
		String read = "sim";
		String status = "1";
		String delivered = "1";
		String confirmationDate = "2016-01-31";

		papovaiHttpClientConnector.send(numbers, message, date);
		papovaiHttpClientConnector.search(numbers, startDate, endDate, ids, status, delivered, confirmationDate);
		papovaiHttpClientConnector.get(numbers, startDate, endDate, ids, read);
		
//		EnviaSMS.send("48996465546", "Teste de envio sms com parametros...");
	}
}