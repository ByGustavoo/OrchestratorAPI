package br.com.wisetechnology.orchestrator.repository;

import br.com.wisetechnology.orchestrator.model.cep.EstadoDTO;
import br.com.wisetechnology.orchestrator.model.cep.RegiaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class EstadoRepository {

    @Autowired
    JdbcClient jdbcClient;

    public void saveState(EstadoDTO pEstadoDTO) {

        var regionId = findRegionIdBySigla(pEstadoDTO.getRegiao().getSigla());

        String query = """
                INSERT INTO estados(id_regiao, sigla, nome)
                VALUES( ?, ?, ? );
                """;

        jdbcClient.sql(query)
                .param(regionId)
                .param(pEstadoDTO.getSigla())
                .param(pEstadoDTO.getNome())
                .query();
    }

    public void saveRegion(RegiaoDTO pRegiaoDTO) {

        String query = """
                INSERT INTO regiao(sigla, nome)
                VALUES( ?, ? );
                """;

        jdbcClient.sql(query)
                .param(pRegiaoDTO.getSigla())
                .param(pRegiaoDTO.getNome())
                .query();
    }

    private Integer findRegionIdBySigla(String pSigla) {

        String query = """
                SELECT r.id
                FROM regiao r
                WHERE r.sigla = ?
                """;

        return jdbcClient.sql(query)
                .param(pSigla)
                .query(Integer.class)
                .single();
    }
}