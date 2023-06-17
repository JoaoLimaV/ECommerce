package Proxy;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.simple.JSONObject;
import Singleton.SingletonKeyJson;

public class ProxyConnection implements ServiceConnection {
	
	private static final Logger LOG = Logger.getLogger(ProxyConnection.class.getName());

	public static JSONObject getConnection() {
		
        String requestClass = Thread.currentThread().getStackTrace()[2].getClassName();
        LOG.setLevel(Level.INFO);
        LOG.setUseParentHandlers(false);
        FileHandler fileHandler = null; 
        
        try {
			fileHandler = new FileHandler("src/logProxy.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOG.addHandler(fileHandler);
                   
            if (!requestClass.contains("DAO")) {
                LOG.info("A classe " + requestClass + " teve seu acesso negado a classe de banco de dados\n");
            	return null;
            }
            LOG.info("A classe " + requestClass + " obteve acesso a classe de banco de dados\n");
           
		} catch (Exception e) {}
        
        finally {
        	fileHandler.flush();
            fileHandler.close(); 
            fileHandler = null;
        }
        
		return SingletonKeyJson.getConnection();
	}
	
}
