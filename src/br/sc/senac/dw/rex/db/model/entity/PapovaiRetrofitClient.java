//package br.sc.senac.dw.rex.db.model.entity;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.xml.rpc.Call;
//
//import org.jboss.resteasy.annotations.Query;
//
//
//public interface PapovaiRetrofitClient {
//
//	@POST("/webservice/1.0/send")
//	public Call<ResponseBody> send(@Query("user") String user, @Query("pass") String pass, @Query("numbers") String numbers,
//			@Query("message") String message, @Query("date") String date, @Query("return_format") String return_format);
//
//	@GET("/webservice/1.0/search")
//	public Call<ResponseBody> search(@Query("user") String user, @Query("pass") String pass, @Query("numbers") String numbers,
//			@Query("data_start") String startDate, @Query("data_end") String endDate, @Query("ids") String ids,
//			@Query("status") String status, @Query("entregue") String delivered, @Query("data_confirmacao") String confirmationDate, 
//			@Query("return_format") String return_format);
//	
//	@GET("/webservice/1.0/get")
//	public Call<ResponseBody> get(@Query("user") String user, @Query("pass") String pass, @Query("numbers") String numbers,
//			@Query("data_start") String startDate, @Query("data_end") String endDate, @Query("ids") String ids,
//			@Query("lido") String read, @Query("return_format") String return_format);
//	
//}