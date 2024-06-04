package edu.badpals.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Repositorio {
    @Inject
    RepoItem repoItem;
    @Inject
    RepoWizard repoWizard;
    
}
