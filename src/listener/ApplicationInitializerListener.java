package listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import Kodu3DB.SetupDao;

public class ApplicationInitializerListener implements ServletContextListener{

   @Override
   public void contextInitialized(ServletContextEvent arg0) {
      
	   //M‰‰ratakse konstruktoris
	   SetupDao setup = new SetupDao();
  
   }
   
   @Override
   public void contextDestroyed(ServletContextEvent arg0) {
      
   }

}