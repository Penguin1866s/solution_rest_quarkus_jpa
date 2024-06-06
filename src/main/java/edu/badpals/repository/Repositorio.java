package edu.badpals.repository;

import java.util.List;
import java.util.Optional;

import edu.badpals.domain.MagicalItem;
import edu.badpals.domain.Order;
import edu.badpals.domain.Person;
import edu.badpals.domain.Wizard;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class Repositorio {
    @Inject
    RepoItem repoItem;
    @Inject
    RepoWizard repoWizard;
    @Inject
    RepoOrder repoOrder;

    public Optional<Wizard> loadWizard(String name) {
        return this.repoWizard.findByIdOptional(name);
    }
    public Optional<MagicalItem> loadItem(String name){
        return this.repoItem.find("name",name).firstResultOptional();
    }
    public List<MagicalItem> loadItems(String name) {
        return this.repoItem.list("name", name);
    }
    public Optional<MagicalItem> loadItem(MagicalItem item){
        return this.loadItems(item.getName()).stream().filter(it -> it.getName().equals(item.getName()) && it.getQuality()==item.getQuality() && it.getType().equals(item.getType())).findFirst();
    }
    @Transactional
    public Optional<Order> placeOrder(String wizard_nombre , String item_nombre){
        Order order =null;
        Optional<Wizard> wizard = this.repoWizard.findByIdOptional(wizard_nombre);
        Optional<MagicalItem> item = this.repoItem.find("name = ?1", item_nombre).firstResultOptional();
        if(wizard.isPresent() && item.isPresent() && !wizard.get().getPerson().equals(Person.MUDBLOOD)){
            order = new Order();
            order.setItem(item.get());
            order.setWizard(wizard.get());
            this.repoOrder.persist(order);
        }
        
        return Optional.ofNullable(order);

    }
}
