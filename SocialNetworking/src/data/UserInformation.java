package data;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Socialnetwork;


/**
 * Servlet implementation class UserInformation
 */
@WebServlet("/UserInformation")
public class UserInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userid = request.getParameter("userid");
		
		List<Socialnetwork> userInfo = getUserInfo(userid);
		
		try
		{
			request.setAttribute("Socialnetwork", userInfo);
		}
		catch(Exception e)
		{
			request.setAttribute("message", "<div class='alert alert-danger' role='alert'>Error! Danger Will Robinson Danger! " + e + "</div>");
		}
		
		getServletContext()
		.getRequestDispatcher("/userInfo.jsp")
		.forward(request, response);
		
		
		
	}
	
	protected static List<Socialnetwork> getUserInfo(String userid)
	{
		
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT p FROM  Socialnetwork p where p.userid = :userid";
		TypedQuery<Socialnetwork> q = em.createQuery(qString, Socialnetwork.class);
		q.setParameter("userid", Long.parseLong(userid));
		List<Socialnetwork> i = null;
		try
		{
		
			i = q.getResultList();
			if(i == null || i.isEmpty())
			{
				i = null;
			}
		}
		catch(NoResultException e)
		{
			System.out.println(e);
		}
		
		finally 
		{
			em.close();
		}
		System.out.println(i);
		
		return i;
	}
	

}
