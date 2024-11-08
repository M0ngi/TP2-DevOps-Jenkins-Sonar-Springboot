# TP2 DevOps GL5

- Springboot app exposing a REST API
- JUnit for testing
- Jenkins for CI/CD Pipeline
- SonarQube for SAST
- Snyk for SAST/DAST

---

For Jenkins & SonarQube, we used a local instance, created using the publicly available docker image for both Jenkins & SonarQube. In order to use docker inside Jenkins, we used DinD (Docker inside Docker), therefore, we made our own image, based on Jenkins provided image, in order to configure it properly.

Here you can find our [docker-compose.yaml](./jenkins.compose.yaml)

---

CI/CD Pipeline ([Jenkinsfile](./Jenkinsfile)) consists of:

1. Building the Springboot Project.
2. Running JUnit tests.
3. Using **SonarQube** for static code analysis.
4. Verifying quality gate.
5. Building docker image.
6. Publishing docker image to a private Dockerhub repository.
7. Triggering a `Snyk CI` pipeline using the newly generated image tag.

`Snyk CI` pipeline ([Jenkinsfile](./snyk.Jenkins)) is a parameterized pipeline, taking as argument an image tag (ex. latest) & runs a Snyk docker image scan on the published image.
