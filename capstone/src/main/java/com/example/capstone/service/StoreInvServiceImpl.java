package com.example.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.repository.StoreRepository;

@Service
public class StoreInvServiceImpl implements StoreService{

	@Autowired
	StoreRepository storeRepository;
}
