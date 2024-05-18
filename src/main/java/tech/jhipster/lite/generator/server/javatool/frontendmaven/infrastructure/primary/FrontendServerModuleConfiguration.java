package tech.jhipster.lite.generator.server.javatool.frontendmaven.infrastructure.primary;

import static tech.jhipster.lite.generator.slug.domain.JHLiteFeatureSlug.*;
import static tech.jhipster.lite.generator.slug.domain.JHLiteModuleSlug.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.javatool.frontendmaven.application.FrontendServerApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class FrontendServerModuleConfiguration {

  @Bean
  JHipsterModuleResource frontendMavenModule(FrontendServerApplicationService frontendServer) {
    return JHipsterModuleResource.builder()
      .slug(FRONTEND_MAVEN_PLUGIN)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addProjectBaseName().addIndentation().build())
      .apiDoc("Frontend Maven Plugin", "Add Frontend Maven Plugin")
      .organization(
        JHipsterModuleOrganization.builder()
          .feature(FRONTEND_SERVER_PLUGIN)
          .addDependency(SPRING_SERVER)
          .addDependency(CLIENT_CORE)
          .addDependency(MAVEN_JAVA)
          .build()
      )
      .tags("server", "tools")
      .factory(frontendServer::buildFrontendMavenModule);
  }

  @Bean
  JHipsterModuleResource frontendGradleModule(FrontendServerApplicationService frontendServer) {
    return JHipsterModuleResource.builder()
      .slug(NODE_GRADLE_PLUGIN)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addProjectBaseName().addIndentation().build())
      .apiDoc("Frontend Gradle Plugin", "Add node-gradle plugin for building frontend with Gradle")
      .organization(
        JHipsterModuleOrganization.builder()
          .feature(FRONTEND_SERVER_PLUGIN)
          .addDependency(SPRING_SERVER)
          .addDependency(CLIENT_CORE)
          .addDependency(GRADLE_JAVA)
          .build()
      )
      .tags("server", "tools")
      .factory(frontendServer::buildFrontendGradleModule);
  }
}
