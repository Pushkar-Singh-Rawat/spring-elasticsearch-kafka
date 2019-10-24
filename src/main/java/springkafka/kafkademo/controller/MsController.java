package springkafka.kafkademo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springkafka.kafkademo.messagemodel.MessageModel;
import springkafka.kafkademo.service.DemoService;

@RestController
public class MsController {

	private DemoService demoService;
	public MsController(DemoService demoService) {
		this.demoService=demoService;
	}
	
	@GetMapping("/v1/message/send")
	public void sendMessage(@RequestParam("msg") String msg) {
		MessageModel messageObj=new MessageModel();
		messageObj.setSampleMessage(msg);
		demoService.sendMessage(messageObj);
	}
}
