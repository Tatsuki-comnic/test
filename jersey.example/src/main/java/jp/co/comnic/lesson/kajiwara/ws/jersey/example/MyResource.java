
package jp.co.comnic.lesson.kajiwara.ws.jersey.example;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";     
    }

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public int sum(@FormParam("a") int x, @FormParam("b") int y) {
		return x + y;
}
}