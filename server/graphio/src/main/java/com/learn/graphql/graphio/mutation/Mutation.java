package com.learn.graphql.graphio.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.learn.graphql.graphio.model.Post;
import com.learn.graphql.graphio.repository.PostRepository;

@Component
public class Mutation implements GraphQLRootResolver{

	@Autowired
	private PostRepository postRepository;
	
	public Post createPost(String imageUrl, String description){
		Post post = new Post(imageUrl, description);
		post = postRepository.save(post);
		return post;
	}
	
}
