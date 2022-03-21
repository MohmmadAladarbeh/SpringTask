package com.example.demo;

import com.example.demo.domain.Albums;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void constructor() {
		Albums albums = new Albums("song", "moham", 7,"url");
		assertEquals("song", albums.getTitle());
		assertEquals("moham", albums.getArtist());
	}

}
