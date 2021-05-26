package com.uudaddy.SpringBootReact.demo;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
/*
	@Test
	public void contextLoads() {
	}
*/
	@Test
	public void givenUsingCommonsIO_whenConvertingAnInputStreamToAByteArray_thenCorrect()
			throws IOException {
		ByteArrayInputStream initialStream = new ByteArrayInputStream(new byte[] { 0, 1, 2 });

		byte[] targetArray = IOUtils.toByteArray(initialStream);
	}

}

