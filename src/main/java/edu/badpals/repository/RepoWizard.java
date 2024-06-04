package edu.badpals.repository;

import edu.badpals.domain.Wizard;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepoWizard implements PanacheRepository<Wizard> {
    
}
