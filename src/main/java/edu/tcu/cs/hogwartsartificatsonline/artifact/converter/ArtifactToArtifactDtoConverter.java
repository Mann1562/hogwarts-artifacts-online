package edu.tcu.cs.hogwartsartificatsonline.artifact.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.tcu.cs.hogwartsartificatsonline.artifact.*;
import edu.tcu.cs.hogwartsartificatsonline.artifact.dto.ArtifactDto;
import edu.tcu.cs.hogwartsartificatsonline.wizard.converter.WizardToWizardDtoConverter;

@Component
public class ArtifactToArtifactDtoConverter implements Converter<Artifact, ArtifactDto> {

    private final WizardToWizardDtoConverter wizardToWizardDtoConverter;

    public ArtifactToArtifactDtoConverter(WizardToWizardDtoConverter wizardToWizardDtoConverter) {
        this.wizardToWizardDtoConverter = wizardToWizardDtoConverter;
    }

    @Override
    public ArtifactDto convert(Artifact source) {
        ArtifactDto artifactDto = new ArtifactDto(source.getId(), 
                                                    source.getName(),
                                                    source.getDescription(), 
                                                    source.getImageURL(), 
                                                    source.getOwner() != null 
                                                    ? this.wizardToWizardDtoConverter.convert(source.getOwner())
                                                    :null);
        return artifactDto;
    }

}
