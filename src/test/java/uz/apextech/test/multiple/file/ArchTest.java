package uz.apextech.test.multiple.file;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("uz.apextech.test.multiple.file");

        noClasses()
            .that()
            .resideInAnyPackage("uz.apextech.test.multiple.file.service..")
            .or()
            .resideInAnyPackage("uz.apextech.test.multiple.file.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..uz.apextech.test.multiple.file.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
