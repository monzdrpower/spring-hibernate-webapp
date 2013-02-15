package web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

import service.ContractorServiceImpl

@Controller
@RequestMapping("/contractor")
class ContractorController {

	@Autowired
	ContractorServiceImpl contractorService

	@RequestMapping(value = "/create", method=RequestMethod.GET)
	ModelAndView create(@RequestParam(required = false, defaultValue = 'test contractor') String contractorName){

		def list = contractorService.list()

		def contractor
		if(list){
			contractor = list[0]
		} else if(!list){
			contractor = contractorService.create(contractorName)
		}

		ModelAndView mav = new ModelAndView()
		mav.addObject("contractor", contractor)
		mav
	}

	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	ModelAndView delete(@RequestParam Long id){

		contractorService.delete(id)

		ModelAndView mav = new ModelAndView()
		mav.addObject("result", 'OK')
		mav
	}

	@RequestMapping(value = "/list", method=RequestMethod.GET)
	ModelAndView list(){

		def list = contractorService.list()

		ModelAndView mav = new ModelAndView()
		mav.addObject("list", list)
		mav
	}
}
