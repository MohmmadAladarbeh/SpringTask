package com.example.demo;

import com.example.demo.domain.Albums;
import com.example.demo.web.AppController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	AppController appController;

	@Test
	void constructor() {
		Albums albums = new Albums("song", "moham", 7,"url");
		assertEquals("song", albums.getTitle());
		assertEquals("moham", albums.getArtist());
	}


	// Hello Test
	@Test
	void helloTest () {
		String result = appController.getHello();
		assertEquals("hello", result);
	}


}
