//package br.sc.senac.dw.rex.controller;
//
//import java.io.IOException;
//
//
//public class RetrofitMain {
//
//    public static void main( String[] args ) throws IOException {
//		br.sc.senac.dw.rex.db.model.PapovaiRetrofitConnector papovaiRetrofitConnector = new br.sc.senac.dw.rex.db.model.PapovaiRetrofitConnector();
//		
//		String numbers = "4100000000";
//		String message = "Mensagem de teste.";
//		String date = "2016-01-31 21:25";
//		String startDate = "2016-01-25";
//		String endDate = "2016-01-31";
//		String ids = "1;2;3;45";
//		String read = "sim";
//		String status = "1";
//		String delivered = "1";
//		String confirmationDate = "2016-01-31";
//
//		papovaiRetrofitConnector.send(numbers, message, date);
//		papovaiRetrofitConnector.get(numbers, startDate, endDate, ids, read);
//		papovaiRetrofitConnector.search(numbers, startDate, endDate, ids, status, delivered, confirmationDate);
//    }
//}