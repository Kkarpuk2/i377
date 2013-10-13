package listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import Kodu3DB.SetupDao;

public class ApplicationInitializerListener implements ServletContextListener{

	@Override
	   public void contextInitialized(ServletContextEvent arg0) {
	      SetupDao setupDao = new SetupDao();

	      if(!databaseExists()) {
	         setupDao.createSchema();
	         setupDao.addTestData();
	      }
	   }

	   @Override
	   public void contextDestroyed(ServletContextEvent arg0) {
	      
	   }

	   private boolean databaseExists() {
	      return new File(System.getProperty("user.home") + "/data/Kkarpuk2/db.script").exists();
	   }
	}