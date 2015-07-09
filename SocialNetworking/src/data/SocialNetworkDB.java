package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import model.Socialnetwork;
import mytools.DBUtil;

public class SocialNetworkDB
{
	public static List<Socialnetwork> getSocialNetworkers()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT s FROM Socialnetwork s";
		TypedQuery<Socialnetwork> q = em.createQuery(qString, Socialnetwork.class);
				
		
		List<Socialnetwork> users = null;
		
		try	// actually get the scores from the database
		{
			users = q.getResultList();
			if (users == null || users.isEmpty())
				users = null;
			return users;
		}
		catch (Exception e)
		{
			System.out.println("A problem occurred while retrieving users: " + e);
			return null;
		}
		finally 
		{
			em.close();
		}
	}
	
	public static Socialnetwork getSocialNetworkerById(long id)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try
		{
			Socialnetwork user = em.find(Socialnetwork.class, id);
			return user;
		}
		finally
		{
			em.close();
		}
	}
	
	public static Socialnetwork getSocialNetworkerByEmailPassword(String email, String password)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT s FROM Socialnetwork s WHERE s.password = :password AND s.emailid = :emailid";
		TypedQuery<Socialnetwork> q = em.createQuery(qString, Socialnetwork.class);
		q.setParameter("emailid", email);
		q.setParameter("password",	password);
		
		List<Socialnetwork> users = null;
		Socialnetwork user;
		
		try	// actually get the scores from the database
		{
			users = q.getResultList();
			if (users == null || users.isEmpty())
				return null;
			
			else return users.get(0);
			
		}
		catch (Exception e)
		{
			System.out.println("A problem occurred while retrieving users: " + e);
			return null;
		}
		finally 
		{
			em.close();
		}
	}
}
