package himedia.phonebook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
//	게시물 작성 폼
	@GetMapping("/write")
	public String writeForm() {
		return "phonebook/writeForm";
	}
	
	@PostMapping("/write")
	public String writeAction(@ModelAttribute PhonebookVo phonebookVo) {
		
		logger.debug("PHONEBOOK WRITE:" + phonebookVo);
		boolean success = phonebookServiceImpl.insertPhonebook(phonebookVo);
		
		if(success) {
			return "redirect:/";
		} else {
			return "redirect:/write";
			
		}
	}
	
	
//	게시물 수정 폼
	@GetMapping("/modify/{id}")
	public String modifyForm(@PathVariable("id") Integer id, Model model) {

//		기존 게시물 가져오기
		PhonebookVo phonebookVo = phonebookServiceImpl.selectPhonebook(id);
		model.addAttribute("vo", phonebookVo);
		return "phonebook/modifyForm";
	}
	
//	게시물 수정
	@PostMapping("/modify")
	public String modifyAction(@ModelAttribute PhonebookVo phonebookVo) {
		logger.debug("PHONEBOOK MODIFY:" + phonebookVo);
		boolean success = phonebookServiceImpl.updatePhonebook(phonebookVo);
		
		if(success) {
			return "redirect:/";
		} else {
			return "redirect:/modify/" + phonebookVo.getId();
		}
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAction(@PathVariable("id") Integer id) {
		logger.debug("PHONEBOOK DELETE:" + id);
		phonebookServiceImpl.deletePhonebook(id);
		
		return "redirect:/";
	}
 	
}
