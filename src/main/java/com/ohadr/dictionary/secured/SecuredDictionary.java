package com.ohadr.dictionary.secured;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/secure/test")
public class SecuredDictionary 
{
	private static Logger log = Logger.getLogger(SecuredDictionary.class);

	public void doSomething(HttpServletResponse resp) throws IOException 
	{
		log.info("im here");
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}

}
