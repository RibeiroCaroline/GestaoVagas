package br.com.carolineribeiro.gestao_vagas.repository;

import br.com.carolineribeiro.gestao_vagas.modules.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);

    Optional<CompanyEntity>findByUsername(String username);
}
