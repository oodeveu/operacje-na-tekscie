plugins {
    id("java")
    id("application")
    // Zmieniono wersję na prawidłową 0.1.0, która znajduje się w repozytorium Gradle
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "eu.oodev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        // Pozostaje konfiguracja pod Twoją Javę 24
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}

javafx {
    // Wersja bibliotek JavaFX renderujących HTML
    version = "21.0.5"
    // Wymagane moduły do stworzenia okna z widokiem HTML
    modules("javafx.controls", "javafx.web")
}

application {
    // Upewnij się, że ta klasa istnieje w src/main/java/eu/oodev/Main.java
    mainClass.set("eu.oodev.Main")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
