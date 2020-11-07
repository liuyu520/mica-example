package net.dreamlu.example;


import io.swagger.annotations.Api;
import net.dreamlu.mica.annotation.UrlVersion;
import net.dreamlu.mica.annotation.VersionMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@VersionMapping(urlVersion = "v1-1")
@Api(description = "接口版本演示")
public class TestDemoController {

	@GetMapping("sayHello")
	@UrlVersion("v1-0")
	public String sayHello() {
		return "Hello world";
	}
}
