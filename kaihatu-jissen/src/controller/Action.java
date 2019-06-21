package controller;


public class Action {
	public interface Action {
		public Dispatcher execute(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException;
	}

}
