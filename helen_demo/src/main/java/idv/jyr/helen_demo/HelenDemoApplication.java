package idv.jyr.helen_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"idv.jyr.helen_demo.*"})
public class HelenDemoApplication {

//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
//	{
//		return application.sources(HelenDemoApplication.class);
//	}
	public static void main(String[] args) {
		SpringApplication.run(HelenDemoApplication.class, args);
	}

}
