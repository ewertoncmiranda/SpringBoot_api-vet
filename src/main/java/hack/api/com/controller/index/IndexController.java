package hack.api.com.controller.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hack.api.com.servico.VacinaService;

@Controller
@RequestMapping(value = "/index")
public class IndexController {

	@Autowired
	VacinaService vcs;

	@GetMapping(value = "/hi")
	public ModelAndView hi() {
	 ModelAndView mv  = new ModelAndView("/pages/home/index");
	 return mv ;	 		
	}

	@GetMapping(value = "/ola")
	public String ola() {
	 return "/pages/home/index";

	}

}
