package com.nulltemp.controller;

import com.nulltemp.config.TestConfig;
import com.nulltemp.constant.MessageConstant;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig(TestConfig.class)
public class MessageControllerTest {
	@Autowired
	private WebApplicationContext context;
	@Autowired
	private MessageSource messageSource;

	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@TestInstance(Lifecycle.PER_CLASS)
	@Nested
	class 名前なし {
		@ParameterizedTest
		@MethodSource("testArgs")
		void test(Locale locale, TestReporter testReporter) throws Exception {
			String expected = messageSource.getMessage(MessageConstant.KEY_HELLO,
					new String[] { MessageConstant.DEFAULT_NAME }, locale);
			testReporter.publishEntry("expected", expected);
			mockMvc.perform(get("/api/messages/hello").locale(locale)).andExpect(status().isOk())
					.andExpect(content().string(expected));
		}

		Stream<Locale> testArgs() {
			return Stream.of(Locale.JAPAN, Locale.US);
		}
	}

	@Test
	void 名前あり(TestReporter testReporter) throws Exception {
		String name = "nulltemp";
		String expected = messageSource.getMessage(MessageConstant.KEY_HELLO,
				new String[] { name }, Locale.US);
		testReporter.publishEntry("expected", expected);
		mockMvc.perform(get("/api/messages/hello?name={name}", name).locale(Locale.US))
				.andExpect(status().isOk())
				.andExpect(content().string(expected));
	}
}
