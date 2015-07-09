

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Socialnetwork;
import data.SocialNetworkDB;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String url;
		String email = (String) request.getParameter("emailid");
		String password = (String) request.getParameter("password");
		
		Socialnetwork user = SocialNetworkDB.getSocialNetworkerByEmailPassword(email, password);
		
		if (user == null)
		{
			// null user indicates no user matching login credentials forward to 
			// loginFailed.jsp with error message and no authentication session variable
			request.setAttribute("message", "Either the correct email or password was missing.");
			session.setAttribute("authenticatedUser", null);
			url = "/loginFailed.jsp";
		}
		else
		{
			session.setAttribute("authenticatedUser", user);
			List<Socialnetwork> users = SocialNetworkDB.getSocialNetworkers();
			request.setAttribute("userList", users);
			url = "/displayUsers.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
		// validation of SocialNetworkDB methods below
		/*List<Socialnetwork> users = SocialNetworkDB.getSocialNetworkers();
		
		Socialnetwork user = SocialNetworkDB.getSocialNetworkerById((long)2);
		
		Socialnetwork authenticatedUser = SocialNetworkDB.getSocialNetworkerByEmailPassword(email, password);
		
		System.out.println("Output from getSocialNetworkerById: " +  user.getCity());
		
		System.out.println("Output from getSocialNetworkerByEmailPassword: " +  user.getState()); */
	}

}
