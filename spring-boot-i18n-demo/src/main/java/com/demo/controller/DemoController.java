package com.demo.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/test")
public class DemoController {
	
	@Autowired
	private MessageSource messageSource;
	
	 /**
	 * 取得當前語系.
	 *
	 * @param rq the rq
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping(value = { "/getCurrentLocale" }, method = { RequestMethod.GET }, consumes = {MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<JSONObject> changeLocale(HttpServletRequest request, HttpServletResponse response) {
		Locale locale = LocaleContextHolder.getLocale();
		
		JSONObject json = new JSONObject();
		json.put("locale", "當前語系:" + messageSource.getMessage("current.locale", null, locale));

		return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
	}

//    @Autowired
//    private DemoReloadableResourceBundleMessageSource messageSource;
//
//    @GetMapping("/message")
//    public void message() {
//
//        String s1 = messageSource.getMessage("demo.message", null, Locale.ENGLISH);
//        System.out.println(s1); // MessageSource config
//
//        String s2 = messageSource.getMessage("demo.message", null, Locale.TAIWAN);
//        System.out.println(s2); // MessageSource 配置
//
//        String s3 = messageSource.getMessage("demo.hello-world", null, Locale.ENGLISH);
//        System.out.println(s3); // Hello World
//
//        String s4 = messageSource.getMessage("demo.hello-world", null, Locale.TAIWAN);
//        System.out.println(s4); // 哈囉世界
//
//        messageSource.clearCache();
//
//        Properties messagesProperties = messageSource.getProperties(Locale.ENGLISH);
//        messagesProperties.setProperty("demo.message", "ReloadableResourceBundleMessageSource example");
//
//        Properties messagesZhTwProperties = messageSource.getProperties(Locale.TAIWAN);
//        messagesZhTwProperties.setProperty("demo.message", "ReloadableResourceBundleMessageSource 範例");
//
//    }
//
//    @GetMapping("/message/new")
//    public void newMessage() {
//        String s1 = messageSource.getMessage("demo.message", null, Locale.ENGLISH);
//        System.out.println(s1); // ReloadableResourceBundleMessageSource example
//
//        String s2 = messageSource.getMessage("demo.message", null, Locale.TAIWAN);
//        System.out.println(s2); // ReloadableResourceBundleMessageSource 範例
//
//        String s3 = messageSource.getMessage("demo.hello-world", null, Locale.ENGLISH);
//        System.out.println(s3); // Hello World
//
//        String s4 = messageSource.getMessage("demo.hello-world", null, Locale.TAIWAN);
//        System.out.println(s4); // 哈囉世界
//    }

}
