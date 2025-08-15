package br.com.wisetechnology.orchestrator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class CepRepository {

    @Autowired
    JdbcClient jdbcClient;

    public String findCep(String cep) {

        String query = """
                SELECT c.cep
                FROM cep c
                WHERE c.cep = ?
                """;

        return jdbcClient
                .sql(query)
                .query(String.class)
                .optional()
                .orElse(null);
    }
}