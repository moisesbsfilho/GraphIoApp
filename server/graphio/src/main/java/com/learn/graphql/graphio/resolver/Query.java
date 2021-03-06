package com.learn.graphql.graphio.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.learn.graphql.graphio.model.Post;
import com.learn.graphql.graphio.repository.PostRepository;

@Component
public class Query implements GraphQLRootResolver {

	@Autowired
	private PostRepository postRepository;

	public Query(){
		super();
	}

	public List<Post> allPosts() {
		return (List<Post>) postRepository.findAll();
	}

}
