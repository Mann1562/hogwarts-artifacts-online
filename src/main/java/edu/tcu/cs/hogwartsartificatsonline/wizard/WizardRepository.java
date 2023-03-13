package edu.tcu.cs.hogwartsartificatsonline.wizard;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Integer>{
    
}
