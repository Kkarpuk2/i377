package Kodu3DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Kodu3DB.Item;

public class Dao extends AbstractDao {
	
	
	public List<Item> search(String search) throws SQLException{
		      List<Item> items = new ArrayList<Item>();
		     
		      try {
		         st = getConnection().createStatement();
		         rs = st.executeQuery("SELECT * FROM unit WHERE LCASE(name) LIKE '%" + search.toLowerCase() + "%'");

		         while(rs.next()) {
		            Item item = new Item();
		            item.setId(rs.getInt("id"));
		            item.setName(rs.getString("name"));
		            item.setCode(rs.getString("code"));
		            items.add(item);
		         }
		         
		      }
		      finally {
		         closeResources();
		      }
		      return items;
		   }
   

   
   public boolean addItem(String name, String code) throws SQLException {
      try {
         st = getConnection().createStatement();
         rs = st.executeQuery("INSERT INTO UNIT VALUES (NEXT VALUE FOR seq1), '" + name + "', '" + code + "'");
      }
      finally {
         closeResources();
      }
      return true;
   }
   
   public boolean deleteItem(int id) throws SQLException {
	      try {
	         st = getConnection().createStatement();
	         rs = st.executeQuery("DELETE FROM UNIT WHERE id = " + id);
	      }
	      finally {
	         closeResources();
	      }
	      return true;
	   }

   
   public List<Item> findAllItems() throws SQLException {
	   List<Item> items = new ArrayList<Item>();
		try {
		st =getConnection().createStatement();
		rs = st.executeQuery("SELECT * FROM unit");
		while(rs.next()){
			Item item = new Item();
			item.setId(rs.getInt(1));
			item.setName(rs.getString(2));
			item.setCode(rs.getString(3));
			items.add(item);

		}
		} finally {
		      closeResources();
		    }
		return items;
	}
   
   public void deleteAll() throws SQLException {
	      try {
	         st = getConnection().createStatement();
	         rs = st.executeQuery("DELETE FROM UNIT");
	      }
	      finally {
	         closeResources();
	      }
	   
	   }

}