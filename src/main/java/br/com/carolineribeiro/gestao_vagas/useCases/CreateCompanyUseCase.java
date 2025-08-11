package br.com.carolineribeiro.gestao_vagas.useCases;

import br.com.carolineribeiro.gestao_vagas.exceptions.UserFoundException;
import br.com.carolineribeiro.gestao_vagas.modules.CompanyEntity;
import br.com.carolineribeiro.gestao_vagas.repository.CompanyRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

 ;   public CompanyEntity execute(CompanyEntity companyEntity){

        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
            throw new UserFoundException();
        });

        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);

         return this.companyRepository.save(companyEntity);
    }
}
