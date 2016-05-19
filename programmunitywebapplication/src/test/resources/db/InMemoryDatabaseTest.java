package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.tools.Server;

public class InMemoryDatabaseTest
{
	public static void main(String[] args)
	{
		// open the in-memory database within a VM
		try
		{
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(
					"jdbc:h2:file:///C:/Users/Basheer/git/programmunity/programmunitywebapplication/src/main/resources/db/testdb");
		} catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// start a TCP server
		// (either before or after opening the database)
		Server server = null;
		try
		{
			server = Server.createTcpServer().start();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// .. use in embedded mode ..

		// or use it from another process:
		System.out.println("Server started and connection is open.");
		System.out.println("URL: jdbc:h2:" + server.getURL() + "/mem:test");

		// now start the H2 Console here or in another process using
		// java org.h2.tools.Console -web -browser

		System.out.println("Press [Enter] to stop.");
		try
		{
			System.in.read();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Stopping server and closing the connection");
		server.stop();
		try
		{
			conn.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
