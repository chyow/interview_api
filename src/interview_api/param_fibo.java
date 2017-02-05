package interview_api;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/fibonacci")
public class param_fibo {

	// Get input
	@GET
	@Path("{id}")
	
	public Response getFibo(@PathParam("id") String id) {

//		Check that the id entered is a valid integer and do error trapping 
		try
		{
			Integer result = Integer.parseInt(id);
			Integer answer = f(result);
			return Response.status(200).entity("Input is " + id + " Value is " + answer).build();

		}
		catch(NumberFormatException e)
		{
		  //If number is not integer,you wil get exception and exception message will be printed
		  System.out.println(e.getMessage());
	      return Response.status(400).entity("Unexpected error").build();

		}
	}
	
	// Function to return fibo value based input of the nth sequence
	public static int f(int n){
	    if (n <= 1) {
	        return n;
	    } else {
	        return f(n - 1) + f(n - 2);
	    }
	}	
}
