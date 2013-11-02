package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.JpaUtil;
import dbNeljas.SetupDao;

public class ApplicationInitializerListener implements ServletContextListener{

	   @Override
	   public void contextInitialized(ServletContextEvent arg0) {
	      SetupDao setupDao = new SetupDao();

	      setupDao.createSchema();
	      setupDao.addTestData();
	      setupDao.initializeEMFactory();
	   }
	   @Override
	   public void contextDestroyed(ServletContextEvent arg0) {
	      JpaUtil.closeFactory();
	   }
	}