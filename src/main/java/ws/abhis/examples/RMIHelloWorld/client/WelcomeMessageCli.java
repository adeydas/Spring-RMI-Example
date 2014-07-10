package ws.abhis.examples.RMIHelloWorld.client;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ws.abhis.examples.RMIHelloWorld.server.WelcomeMessageDef;

public class WelcomeMessageCli {
	private static Logger logger = Logger.getLogger(WelcomeMessageCli.class);
	
	//start client
	public static void main(String[] args) {
		System.out.println("Starting client....");
		try{
		ApplicationContext context = new ClassPathXmlApplicationContext("rmiClientAppContext.xml");
		WelcomeMessageDef rmiClient = (WelcomeMessageDef) context.getBean("WelcomeM");
		rmiClient.sendMessage("Hello World. Enjoy the FIFA world cup!");
		String msg = rmiClient.getMessages();
		System.out.println(msg);
		}
		catch (Exception e){
			logger.error(e);
		}
	}
}
