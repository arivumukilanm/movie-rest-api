package com.example.movie_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_rest_api.repository.CastMemberRepository;

import com.example.movie_rest_api.model.*;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CastMemberService {
	
	@Autowired
	private CastMemberRepository cr;
	
	public void saveCastMember(CastMember cm) {
		cr.save(cm);
	}
	
	public CastMember CastMember(Long id) {
		return cr.findById(id)
				.orElseThrow(() -> new RuntimeException("CastMember not found"));
	}
	
	

}
