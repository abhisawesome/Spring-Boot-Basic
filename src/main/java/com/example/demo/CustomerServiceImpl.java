package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@PersistenceContext
	EntityManager er;
	@Autowired
	CustomerRepo crp;

	@Override
	public List<Customer> getDetailsOfCustomer() {
		// TODO Auto-generated method stub
		
		
		
		String hql="FROM Customer ORDER BY id";
		
		
		return er.createQuery(hql).getResultList();
	}

	@Override
	public boolean count(Customer customerTransfer) {
		// TODO Auto-generated method stub
		
		long id=customerTransfer.getId();
		String hql="FROM Customer WHERE id="+id;
		
		int count=er.createQuery(hql).getResultList().size();
		
		if(count > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	

}
