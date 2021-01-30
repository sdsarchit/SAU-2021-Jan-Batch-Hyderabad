package com.asr.main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
class SpringMVCApplicationTest {
	@Test
	void test() {
		SpringMVCApplication.main(new String[] {});
	}

}
