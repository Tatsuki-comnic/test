package jp.co.comnic.lesson.kajiwara.ws.jersey.example;


import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class RestClient {

    private static Client client = ClientBuilder.newClient();

    public static void main(String[] args) {

        WebTarget target = client.target("http://localhost:8080/myapp")
                .path("/myresource");
        try {
            //String result = target.request().get(String.class);

			Entity<Form> entity = Entity.entity(new Form().param("a", "1").param("b", "2"),
					MediaType.APPLICATION_FORM_URLENCODED_TYPE);

			int result = target.request().post(entity, Integer.class);
			System.out.println(result);
		} catch (BadRequestException e) {
			e.printStackTrace();
		}
	}
}