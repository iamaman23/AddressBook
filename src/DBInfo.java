import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class DBInfo
{
	static Connection con;
	static Vector<String>outer;
	static Vector<Vector<String>>inner;
	static
	{
		try
		{
		 Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","aman");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void getContact(String fname, String lname)
	{
		outer=new Vector<>();
		inner=new Vector<>();
		
		String query="select * from contact where firstname=? and lastname=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ResultSet res=ps.executeQuery();
			
			ResultSetMetaData rsmd=res.getMetaData();
			int cols=rsmd.getColumnCount();
			for(int i=2;i<=cols;i++)
			{
				String colName=rsmd.getColumnName(i);
				outer.add(colName);
			}
			
			while(res.next())
			{
				Vector<String>record=new Vector<>();
				for(int i=2;i<=cols;i++)
				{
					String value=res.getString(i);
					record.add(value);
				}
				inner.add(record);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
