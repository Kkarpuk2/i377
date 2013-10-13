package Kodu3DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Kodu3DB.Item;

public class Dao extends AbstractDao {
	
	
	public List<Item> search(String keyword) throws SQLException{
		      List<Item> items = new ArrayList<Item>();
		      try {
		         st = getConnection().createStatement();
		         rs = st.executeQuery("SELECT * FROM unit WHERE LCASE(name) LIKE '%" + keyword + "%'");
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
      List<Item> kirjed = new ArrayList<Item>();
      try {
         st = getConnection().createStatement();
         rs = st.executeQuery("SELECT * FROM unit");
         while(rs.next()) {
            Item item = new Item();
            item.setId(Integer.parseInt(rs.getString("id")));
            item.setName(rs.getString("name"));
            item.setCode(rs.getString("code"));
            kirjed.add(item);
         }
      } 
      finally {
         closeResources();
      }
      return kirjed;
   }
   
   public boolean deleteAll() throws SQLException {
	      try {
	         st = getConnection().createStatement();
	         rs = st.executeQuery("DELETE FROM UNIT");
	      }
	      finally {
	         closeResources();
	      }
	      return true;
	   }

}