tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":user-domain"))
    implementation(project(":user-application"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.linecorp.kotlin-jdsl:spring-data-kotlin-jdsl-starter-jakarta:${property("springDataKotlinJdslStarter")}")
}
