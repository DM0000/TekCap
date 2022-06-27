package com.example.capstone.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.entity.CartEntity;
import com.example.capstone.entity.CartItem;
import com.example.capstone.entity.ItemEntity;
import com.example.capstone.entity.StoreInvEntity;
import com.example.capstone.repository.StoreInvRepository;
import com.example.capstone.repository.StoreRepository;

@Service
public class StoreInvServiceImpl implements StoreInvService {

	@Autowired
	StoreInvRepository storeInvRepository;

	public List<StoreInvEntity> findall() {
		return storeInvRepository.findAll();
	}

	public List<ItemEntity> storeInvToItems(String name) {

		HashMap<String, List<StoreInvEntity>> storeList = hashStores();
		List<ItemEntity> iList = new ArrayList<>();

		for (StoreInvEntity sItem : storeList.get(name)) {

			iList.add(sItem.getItem());
		}

		return iList;

	}

	public HashMap<String, List<StoreInvEntity>> hashStores() {

		HashMap<String, List<StoreInvEntity>> storeList = new HashMap<String, List<StoreInvEntity>>();
		List<StoreInvEntity> sList = findall();
		for (StoreInvEntity sInv : sList) {
			if (storeList.containsKey(sInv.getStore().getName())) {
				List<StoreInvEntity> tempList = storeList.get(sInv.getStore().getName());
				tempList.add(sInv);
				storeList.put(sInv.getStore().getName(), tempList);
			} else {
				List<StoreInvEntity> tempList = new ArrayList<StoreInvEntity>();
				tempList.add(sInv);
				storeList.put(sInv.getStore().getName(), tempList);
			}

		}
		return storeList;

	}

	public HashMap<String, String> storeTotal(CartEntity cart) {
		HashMap<String, List<StoreInvEntity>> storeList = hashStores();
		List<CartItem> cList = cart.getItems();

		HashMap<String, String> storesTotal = new HashMap<String, String>();
		Double sum = 0.;
		// iterate through each stores inventory
		for (String key : storeList.keySet()) {
			storesTotal.put(key, "No Items Available");
			// check each item in inventory
			for (StoreInvEntity sItem : storeList.get(key)) {

				// check each cart item against store inventory
				for (CartItem cItem : cList) {
					if (cItem.getItem() == sItem.getItem()) {
						sum = sum + sItem.getPrice() * cItem.getQuantity();

						storesTotal.put(key, String.format("$ %.2f", sum));
					}

				}

			}

		}
		return storesTotal;
	}
}
