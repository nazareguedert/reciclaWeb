//package br.sc.senac.dw.rex.db.model;
//
//import java.io.IOException;
//
//
//import br.sc.senac.dw.rex.db.model.entity.PapovaiRetrofitClient; 	
//import retrofit.Call;
//import retrofit.Retrofit;
//
//public class PapovaiRetrofitConnector {
//
//	private static final String HOST = "https://www.paposms.com";
//	private static final String USER = "usuario@mail.com";
//	private static final String PASS = "Minhasenha123";
//	private static final String RETURN_FORMAT = "json";
//			
//	public void send(String numbers, String message, String date) throws IOException {
//		PapovaiRetrofitClient papovaiRetrofitClient = createClient();
//		Call<ResponseBody> call = papovaiRetrofitClient.send(USER, PASS, numbers, message, date, RETURN_FORMAT);
//		System.out.println("Send Response Body: " + call.execute().body().string());
//	}
//
//	public void search(String numbers, String startDate, String endDate, String ids, String status, String delivered, String confirmationDate) throws IOException {
//		PapovaiRetrofitClient papovaiRetrofitClient = createClient();
//		Call<ResponseBody> call = papovaiRetrofitClient.search(USER, PASS, numbers, startDate, endDate, ids, status, delivered, confirmationDate, RETURN_FORMAT);
//		System.out.println("Search Response Body: " + call.execute().body().string());
//	}
//	
//	public void get(String numbers, String startDate, String endDate, String ids, String read) throws IOException {
//		PapovaiRetrofitClient papovaiRetrofitClient = createClient();
//		Call<ResponseBody> call = papovaiRetrofitClient.get(USER, PASS, numbers, startDate, endDate, ids, read, RETURN_FORMAT);
//		System.out.println("Get Response Body: " + call.execute().body().string());
//	}
//
//	private PapovaiRetrofitClient createClient() {
//		return new Retrofit.Builder()
//		    .baseUrl(HOST)
//		    .build()
//		    .create(PapovaiRetrofitClient.class);
//	}
//}