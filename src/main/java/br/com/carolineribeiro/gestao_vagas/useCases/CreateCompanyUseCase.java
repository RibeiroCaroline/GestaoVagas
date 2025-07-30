package br.com.carolineribeiro.gestao_vagas.useCases;

import br.com.carolineribeiro.gestao_vagas.exceptions.UserFoundException;
import br.com.carolineribeiro.gestao_vagas.modules.CompanyEntity;
import br.com.carolineribeiro.gestao_vagas.repository.CompanyRepositoty;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepositoty companyRepositoty;
    public CompanyEntity execute(CompanyEntity companyEntity){

        this.companyRepositoty.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
            throw new UserFoundException();
        });
         return this.companyRepositoty.save(companyEntity);
    }
}
