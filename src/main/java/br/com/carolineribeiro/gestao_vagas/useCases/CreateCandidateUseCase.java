package br.com.carolineribeiro.gestao_vagas.useCases;

import br.com.carolineribeiro.gestao_vagas.exceptions.UserFoundException;
import br.com.carolineribeiro.gestao_vagas.modules.CandidateEntity;
import br.com.carolineribeiro.gestao_vagas.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidateEntity);
    }
}
