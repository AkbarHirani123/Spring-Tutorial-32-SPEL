package com.caveofprogramming.spring.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/caveofprogramming/spring/test/beans/beans.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDAO");

		try {
			List<Offer> offers1 = new ArrayList<Offer>();
			 offers1.add(new Offer(4, "Cave", "cave@caveofprogramming.com",
			 "hello cave"));
			offers1.add(new Offer(6, "Karen", "karen@caveofprogramming.com",
					"cash for software"));

			int[] rvals = offersDao.create(offers1);

			for (int value : rvals) {
				System.out.println("Updated " + value + "rows.");
			}

			List<Offer> offers = offersDao.getOffers();

			for (Offer offer : offers) {
				System.out.println(offer);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());

		}

		((ClassPathXmlApplicationContext) context).close();
	}

}
