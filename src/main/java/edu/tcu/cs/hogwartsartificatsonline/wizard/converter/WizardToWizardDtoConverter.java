package edu.tcu.cs.hogwartsartificatsonline.wizard.converter;

import edu.tcu.cs.hogwartsartificatsonline.wizard.*;
import edu.tcu.cs.hogwartsartificatsonline.wizard.dto.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WizardToWizardDtoConverter implements Converter<Wizard, WizardDto>{
    
    @Override
    public WizardDto convert(Wizard source) {
        WizardDto wizardDto = new WizardDto(source.getId(), 
                                            source.getName(), 
                                            source.getNumberOfArtifacts());
        return wizardDto;
    }

}
