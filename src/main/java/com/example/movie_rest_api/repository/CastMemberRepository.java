package com.example.movie_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie_rest_api.model.CastMember;


@Repository
public interface CastMemberRepository extends JpaRepository<CastMember, Long>{

}
