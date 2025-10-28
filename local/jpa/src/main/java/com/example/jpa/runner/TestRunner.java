package com.example.jpa.runner;

import com.example.jpa.repository.Test1Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestRunner implements ApplicationRunner {
	private final Test1Repository test1Repository;

	@Override
	public void run(ApplicationArguments args) {
		log.info(test1Repository.findAll().toString());
	}
}
