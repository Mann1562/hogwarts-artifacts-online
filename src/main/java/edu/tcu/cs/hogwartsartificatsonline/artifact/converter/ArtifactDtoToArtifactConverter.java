package edu.tcu.cs.hogwartsartificatsonline.artifact.converter;

import edu.tcu.cs.hogwartsartificatsonline.artifact.Artifact;
import edu.tcu.cs.hogwartsartificatsonline.artifact.dto.ArtifactDto;

import org.hibernate.annotations.Comment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArtifactDtoToArtifactConverter implements Converter<ArtifactDto, Artifact> {

    @Override
    public Artifact convert(ArtifactDto source) {
        Artifact artifact = new Artifact();
        artifact.setId(source.id());
        artifact.setName(source.name());
        artifact.setDescription(source.description());
        artifact.setImageURL(source.imageUrl());
        return artifact;
    }
    
}
