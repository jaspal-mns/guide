## Micronaut 3.9.2 Documentation

- [User Guide](https://docs.micronaut.io/3.9.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.9.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.9.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Jib Gradle Plugin](https://plugins.gradle.org/plugin/com.google.cloud.tools.jib)
## Azure Container Instance GraalVM Workflow

Workflow file: [`.github/workflows/azure-container-instance-graalvm.yml`](.github/workflows/azure-container-instance-graalvm.yml)

### Workflow description
For pushes to the `master` branch, the workflow will:
1. Setup the build environment with respect to the selected java/graalvm version.
2. Login to Docker registry.
3. Login to [Azure Command-Line Interface](https://docs.microsoft.com/cs-cz/cli/azure/).
4. Build, tag and push Docker image with Micronaut application to the Docker Registry.
5. Deploy to [Azure Container Instances](https://docs.microsoft.com/cs-cz/azure/container-instances/).

### Dependencies on other GitHub Actions
- [Login to Docker Registry `docker/login`](https://github.com/docker/login-action)
- [Setup GraalVM `DeLaGuardo/setup-graalvm`](https://github.com/DeLaGuardo/setup-graalvm)
- [Setup Azure CLI `azure/login`](https://github.com/Azure/login)

### Setup
Add the following GitHub secrets:

| Name | Description |
| ---- | ----------- |
| DOCKER_USERNAME | Docker registry username. In case of Azure Container Registry, provide Azure username or Service principal ID, see more on [Azure Container Registry authentication with service principals](https://docs.microsoft.com/en-us/azure/container-registry/container-registry-auth-service-principal). |
| DOCKER_PASSWORD | Docker registry password. In case of Azure Container Registry, provide Azure password or Service principal password. |
| DOCKER_REPOSITORY_PATH | Docker image repository. In case of Azure Container Registry, for image `micronaut.azurecr.io/foo/bar:0.1`, the `foo` is an _image repository_. |
| DOCKER_REGISTRY_URL | Docker registry url. In case of Azure Container Registry use the Container registry login path, e.g. for the image `micronaut.azurecr.io/foo/bar:0.1`, the `micronaut.azurecr.io` is a _registry url_. |
| AZURE_CREDENTIALS | Azure Service Principal, see more on [Azure/aci-deploy#Azure Service Principal for RBAC](https://github.com/Azure/aci-deploy#azure-service-principal-for-rbac). |
| AZURE_RESOURCE_GROUP | Azure Resource Group name, see more on [Resource groups](https://docs.microsoft.com/en-us/azure/azure-resource-manager/management/overview#resource-groups). |

The workflow file also contains additional configuration options that are now configured to:

| Name | Description | Default value |
| ---- | ----------- | ------------- |
| AZURE_LOCATION | Location where the Container Instance will be created. See [Resource availability for Azure Container Instances in Azure regions](https://docs.microsoft.com/en-us/azure//container-instances/container-instances-region-availability) to find out what regions are supported. | `westeurope` |
| AZURE_DNS_LABEL | The dns name label for container group with public IP. | `guide` |


### Verification
Call the rest api endpoint `[AZURE_DNS_LABEL].[AZURE_LOCATION].azurecontainer.io:[PORT]/guide`:
```
curl http://guide.westeurope.westeurope.azurecontainer.io:8080/guide
```


- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature flyway documentation

- [Micronaut Flyway Database Migration documentation](https://micronaut-projects.github.io/micronaut-flyway/latest/guide/index.html)

- [https://flywaydb.org/](https://flywaydb.org/)


## Feature azure-cosmos-db documentation

- [Micronaut Azure Cosmos DB documentation](https://micronaut-projects.github.io/micronaut-azure/latest/guide/#azureCosmosClient)

- [https://learn.microsoft.com/en-us/azure/cosmos-db/](https://learn.microsoft.com/en-us/azure/cosmos-db/)


## Feature acme documentation

- [Micronaut ACME documentation](https://micronaut-projects.github.io/micronaut-acme/latest/guide/index.html)


## Feature security-jwt documentation

- [Micronaut Security JWT documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html)


## Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)


## Feature kafka documentation

- [Micronaut Kafka Messaging documentation](https://micronaut-projects.github.io/micronaut-kafka/latest/guide/index.html)


## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


## Feature reactor documentation

- [Micronaut Reactor documentation](https://micronaut-projects.github.io/micronaut-reactor/snapshot/guide/index.html)


## Feature elasticsearch documentation

- [Micronaut Elasticsearch Driver documentation](https://micronaut-projects.github.io/micronaut-elasticsearch/latest/guide/index.html)


## Feature data-azure-cosmos documentation

- [Micronaut Data Azure Cosmos documentation](https://micronaut-projects.github.io/micronaut-data/latest/guide/#azureCosmos)

- [https://learn.microsoft.com/en-us/azure/cosmos-db/](https://learn.microsoft.com/en-us/azure/cosmos-db/)


## Feature test-resources documentation

- [Micronaut Test Resources documentation](https://micronaut-projects.github.io/micronaut-test-resources/latest/guide/)


## Feature github-workflow-azure-container-instance-graalvm documentation

- [https://docs.github.com/en/free-pro-team@latest/actions](https://docs.github.com/en/free-pro-team@latest/actions)


