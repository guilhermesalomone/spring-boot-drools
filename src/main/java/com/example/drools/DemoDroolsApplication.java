package com.example.drools;

import org.kie.api.runtime.KieSession;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.drools.config.DroolsBeanFactory;
import com.example.drools.model.Fact;
import com.example.drools.model.Result;

@SpringBootApplication
public class DemoDroolsApplication implements CommandLineRunner {

	public Result result;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoDroolsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Result result = this.backwardChaining();
        System.out.println(result.getValue());
        result.getFacts()
            .stream()
            .forEach(System.out::println);
	}
	

    public Result backwardChaining() {
        this.result = new Result();
        KieSession ksession = new DroolsBeanFactory().getKieSession();
        ksession.setGlobal("result", result);
        ksession.insert(new Fact("Asia", "Planet Earth"));
        ksession.insert(new Fact("China", "Asia"));
        ksession.insert(new Fact("Great Wall of China", "China"));

        ksession.fireAllRules();

        return result;
    }

}
