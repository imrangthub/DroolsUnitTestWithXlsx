package com.test.drooltest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.imran.drooltest.CustomerService;
import com.imran.drooltest.DrooltestApplication;
import com.imran.model.Product;
import com.imran.service.JewelleryShopService;

@ContextConfiguration(classes = { DrooltestApplication.class, CustomerService.class, JewelleryShopService.class })
@RunWith(SpringRunner.class)
public class DroolServiceTest {

	@Autowired
	private JewelleryShopService jewelleryShopService;
	
	Product productObj = null;
 
	@Before
	public void setUp(){
		productObj = new Product();
		productObj.setType("other");
	}

	
	
	@Test
	public void testDiscount() throws Exception {
		Product poduct = jewelleryShopService.getProductDiscount(productObj);
		assertEquals(poduct.getDiscount(), 20);
	}
	

//	@Test
//	public void giveIndvidualLongStanding_whenFireRule_thenCorrectDiscount() throws Exception {
//		Customer customer = customerService.getDiscount();
//		assertEquals(customer.getDiscount(), 20);
//	}

}
