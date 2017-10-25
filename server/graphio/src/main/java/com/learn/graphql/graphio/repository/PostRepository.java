package com.learn.graphql.graphio.repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.graphql.graphio.model.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

}
