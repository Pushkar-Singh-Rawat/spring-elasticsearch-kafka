package springkafka.kafkademo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springkafka.kafkademo.model.Customer;
import springkafka.kafkademo.service.AddCustomerInfo;

@RestController
@RequestMapping("/v1/customer/")
public class MsController {

	private AddCustomerInfo addCustomerService;
	public MsController(AddCustomerInfo demoService) {
		this.addCustomerService=demoService;
	}
	
	
	@PostMapping("info/add")
	public Customer setCustomerInfo(@RequestParam("name") String name,@RequestParam("id") String id) {
		Customer customer=new Customer();
		customer.setId(id);
		customer.setCustomerName(name);
		return addCustomerService.configureCustomerInfo(customer);
	}
	
   
}
