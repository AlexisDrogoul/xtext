package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.linking.Bug362902StandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug362902StandaloneSetupIdea extends Bug362902StandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.linking.Bug362902RuntimeModule();
        Module ideaModule = new org.eclipse.xtext.linking.idea.Bug362902IdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
