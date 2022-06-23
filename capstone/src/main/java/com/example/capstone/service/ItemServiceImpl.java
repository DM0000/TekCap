package com.example.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.entity.ItemEntity;
import com.example.capstone.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

	
	@Autowired
	private ItemRepository itemRepo;
	
	
	public List<ItemEntity> findAllItems() {
		// TODO Auto-generated method stub
		return itemRepo.findAll();
	}
		
	//trying by id
//	public void addQuantity(Integer id) {
//		ItemEntity item= getById(id).get();
//		item.setQuantity(item.getQuantity()+1);
//}
	
	
		
		public void addQuantity(String name) {
			List<ItemEntity> items=itemRepo.findByName(name);
			for (ItemEntity x:items) {
				x.setQuantity(x.getQuantity()+1);
				itemRepo.save(x);
			}
		}
		
			public void lowerQuantity(String name) {
				List<ItemEntity> items=itemRepo.findByName(name);
				for (ItemEntity x:items) {
					if(x.getQuantity()>0) {
					x.setQuantity(x.getQuantity()-1);
					itemRepo.save(x);
					}
				}
			
			
	}
			
			

       public Optional <ItemEntity> getById(Integer id) {
    	   return itemRepo.findById(id);
       }
	
	public  List<ItemEntity> findByMoreThanZero(){
		return itemRepo.findByQuantityGreaterThan(0);
	}

}
