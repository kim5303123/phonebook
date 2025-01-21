package himedia.phonebook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import himedia.phonebook.repository.vo.PhonebookVo;
import himedia.phonebook.service.PhonebookService;

@Controller
public class PhonebookController {
	private static final Logger logger = LoggerFactory.getLogger(PhonebookController.class);

	@Autowired
	private PhonebookService phonebookServiceImpl;
	
	@GetMapping("/")	
	public String list(Model model) {
		List<PhonebookVo> list = phonebookServiceImpl.selectPhonebookList();
		logger.debug("PHONEBOOK LIST:" + list);
		model.addAttribute("list", list);
		return "phonebook/list";
	}
}
