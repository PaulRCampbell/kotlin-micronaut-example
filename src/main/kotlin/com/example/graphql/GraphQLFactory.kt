package com.example.graphql

import com.example.accounts.Account
import graphql.GraphQL
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import graphql.schema.idl.TypeDefinitionRegistry
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.core.io.ResourceResolver
import jakarta.inject.Singleton
import java.io.BufferedReader
import java.io.InputStreamReader

@Factory
class GraphQLFactory {
    @Bean
    @Singleton
    fun graphQL(resourceResolver: ResourceResolver ) : GraphQL {
        val parser = SchemaParser()

        val generator = SchemaGenerator()

        val typeRegistry = TypeDefinitionRegistry()

        typeRegistry.merge(parser
                            .parse(
                                BufferedReader(
                                    InputStreamReader(
                                        resourceResolver.getResourceAsStream(
                                            "classpath:schema.graphqls").get()))))


        val runTimeWiring = RuntimeWiring.newRuntimeWiring()
            .type("Query") {
                typeWiring -> typeWiring
                .dataFetcher("accounts", AccountsFetcher())}
            .build()

        val graphQLSchema = generator.makeExecutableSchema(typeRegistry, runTimeWiring)

        return GraphQL.newGraphQL(graphQLSchema).build()

    }
}

class AccountsFetcher: DataFetcher<List<Account>> {
    override fun get(environment: DataFetchingEnvironment?): List<Account> {
        return emptyList()
    }


}