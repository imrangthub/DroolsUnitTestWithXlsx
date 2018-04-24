package com.imran.drooltest;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuleEngineConfig {

	private final KieServices ks = KieServices.Factory.get();
	private static final String RULE_SOURCE = "rules/discountTwo.xlsx";

	@Bean
	public KieFileSystem getKieFileSystem() {
		KieFileSystem kfs = ks.newKieFileSystem();
		/*
		 * List<String> rules = Arrays.asList(); for(String s : rules){
		 * kfs.write(ResourceFactory.newClassPathResource(s)); }
		 */
		kfs.write(ResourceFactory.newClassPathResource(RULE_SOURCE));
		return kfs;
	}

	@Bean
	public KieContainer getKieContainer() {
		KieRepository kRep = ks.getRepository();
		kRep.addKieModule(() -> {
			return kRep.getDefaultReleaseId();
		});

		ks.newKieBuilder(getKieFileSystem()).buildAll();
		return ks.newKieContainer(kRep.getDefaultReleaseId());
	}

	@Bean
	public KieSession getKieSession() {
		return getKieContainer().newKieSession();
	}

}
