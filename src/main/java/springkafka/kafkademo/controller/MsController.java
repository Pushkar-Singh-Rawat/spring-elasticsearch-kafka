package springkafka.kafkademo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springkafka.kafkademo.model.Customer;
import springkafka.kafkademo.service.DemoService;

@RestController
public class MsController {

	private DemoService demoService;
	public MsController(DemoService demoService) {
		this.demoService=demoService;
	}
	
	@GetMapping("/v1/customer/info")
	public void setCustomerInfo(@RequestParam("name") String name,@RequestParam("id") String id) {
		Customer customer=new Customer();
		customer.setId(id);
		customer.setCustomerName(name);
		demoService.configureCustomerInfo(customer);
	}
}
