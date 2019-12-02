package com.warmachine.errorcenterapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testHelloWorld {

	@Test
	public void helloWorld() {
		assertEquals(1, 1);
	}
}
