package com.learn.graphql.graphio.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.learn.graphql.graphio.model.Post;
import com.learn.graphql.graphio.repository.PostRepository;

public class Query implements GraphQLRootResolver {

	private final PostRepository postRepository;

	public Query(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> allPosts() {
		return (List<Post>) postRepository.findAll();
	}

}
