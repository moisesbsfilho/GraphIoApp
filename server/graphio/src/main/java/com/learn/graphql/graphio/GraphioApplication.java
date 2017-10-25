package com.learn.graphql.graphio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.coxautodev.graphql.tools.SchemaParser;
import com.learn.graphql.graphio.mutation.Mutation;
import com.learn.graphql.graphio.resolver.Query;

import graphql.schema.GraphQLSchema;

@SpringBootApplication
public class GraphioApplication {

	@Autowired
	private Query query;
	
	@Autowired
	private Mutation mutation;
	
	public static void main(String[] args) {
		SpringApplication.run(GraphioApplication.class, args);
	}
	
	@Bean
    GraphQLSchema schema() {
        return SchemaParser.newParser().file("schema.graphqls").resolvers(query, mutation).build()
				.makeExecutableSchema();
    }
	
}
