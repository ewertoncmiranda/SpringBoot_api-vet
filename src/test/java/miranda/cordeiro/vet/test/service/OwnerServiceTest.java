package miranda.cordeiro.vet.test.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import miranda.cordeiro.vet.service.OwnerService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class OwnerServiceTest {
	
	@Autowired
	private OwnerService service ;
	
	@Test
	public void findAllOwnersTest() {	
	}
	

}
