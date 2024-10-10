package com.project.service;

import org.springframework.stereotype.Service;

@Service
public class ItemSO {
	public int getStartNum(int page, int limit) {
		return (page - 1) * limit + 1;
	}

	public int getEndNum(int page, int limit) {
		return page * limit;
	}

	public int getSize(int count, int limit) {
		return (count - 1) / limit + 1;
	}
}
