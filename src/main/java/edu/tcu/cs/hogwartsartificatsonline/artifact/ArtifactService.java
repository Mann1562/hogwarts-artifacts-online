package edu.tcu.cs.hogwartsartificatsonline.artifact;
import edu.tcu.cs.hogwartsartificatsonline.artifact.utils.IdWorker;
import org.springframework.stereotype.Service;
import edu.tcu.cs.hogwartsartificatsonline.artifact.ArtifactNotFoundException;
import java.util.List;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArtifactService {
    

    private final ArtifactRepository artifactRepository;

    private final IdWorker idWorker;


    public ArtifactService(ArtifactRepository artifactRepository, IdWorker idWorker) {
        this.artifactRepository = artifactRepository;
        this.idWorker = idWorker;
    }
    
    public Artifact findById(String artifactId) {
        return this.artifactRepository.findById(artifactId)
            .orElseThrow(()-> new ArtifactNotFoundException(artifactId));
    }

    public List<Artifact> findAll() {
        return this.artifactRepository.findAll();
    }

    public Artifact save(Artifact newArtifact) {
        newArtifact.setId(idWorker.nextId() + "");
        return this.artifactRepository.save(newArtifact);
    }

    public Artifact update(String artifactId, Artifact update) {
        return this.artifactRepository.findById(artifactId)
        .map(oldArtifact -> {
            oldArtifact.setName(update.getName());
            oldArtifact.setDescription(update.getDescription());
            oldArtifact.setImageURL(update.getImageURL());
            return this.artifactRepository.save(oldArtifact);
        })
        .orElseThrow(() -> 
            new ArtifactNotFoundException(artifactId)
        );
        

        
    }

    public void delete(String artifactId) {
        this.artifactRepository.findById(artifactId)
            .orElseThrow(() -> new ArtifactNotFoundException(artifactId));
        this.artifactRepository.deleteById(artifactId);
    }

}
