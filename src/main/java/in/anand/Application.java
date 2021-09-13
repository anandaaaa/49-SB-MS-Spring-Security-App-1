package in.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		BCryptPasswordEncoder bpc = new BCryptPasswordEncoder();
		String encode = bpc.encode("dev@123");
		System.out.println(encode);
	}

}
