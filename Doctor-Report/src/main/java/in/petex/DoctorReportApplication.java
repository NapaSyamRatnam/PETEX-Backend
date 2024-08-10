package in.petex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("in.petex")
public class DoctorReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorReportApplication.class, args);
	}

}
