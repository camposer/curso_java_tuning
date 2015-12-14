import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.BeanConfig;
import config.DatabaseConfig;
import gui.PrincipalGui;

public class App {
	public static void main(String[] args) {
		//System.setProperty("spring.profiles.active", "prod");
		
		try (AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext()) {
			
			ctx.getEnvironment().setActiveProfiles("prod");
			ctx.register(DatabaseConfig.class, BeanConfig.class);
			ctx.refresh();
			
			ctx.getBean(PrincipalGui.class).iniciar();
		}
	}
}
