package com.caveofprogramming.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/caveofprogramming/spring/test/beans/beans.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDAO");
		
		Offer offer4 = new Offer(8, "Claire", "claire@caveofprogramming.com", "tester");

		if(offersDao.update(offer4))
			System.out.println("Object updated");
		else
			System.out.println("Object not updated");
		
		try {
//			Offer offer1 = new Offer("Dave", "dave@caveofprogramming.com","coding java");
//			Offer offer2 = new Offer("Karen", "karen@caveofprogramming.com","software testing");
//			
//			if(offersDao.create(offer1))
//				System.out.println("Created offer object");
//			
//			if(offersDao.create(offer2))
//				System.out.println("Created offer object");
//			
			List<Offer> offers = offersDao.getOffers();

			for (Offer offer : offers) {
				System.out.println(offer);
			}
			Offer offer3 = offersDao.getOffer(2);
			System.out.println("Should be mike: "+offer3);
			
//			offer = offersDao.getOffer(6);
//			System.out.println("Should be joe: " + offer);
//
//			System.out.println(offersDao.delete(6));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());

		}
		
		((ClassPathXmlApplicationContext) context).close();
	}

}
