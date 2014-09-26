package com.ohadr.dictionary.secured;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "/secure/test")
public class SecuredDictionary 
{
	private static Logger log = Logger.getLogger(SecuredDictionary.class);

    @RequestMapping(method = RequestMethod.GET)
	public View doSomething(HttpServletResponse resp) throws IOException 
	{
		log.info("im here");
//		resp.setContentType("text/plain");
//		resp.getWriter().println("Hello, world");
		
		RedirectView rv = new RedirectView();
		rv.setUrl("/secure/demo.htm");
		return rv;		
	}

}
