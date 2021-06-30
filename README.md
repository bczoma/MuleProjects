# Mule Connector project with deployment example in Anypoint Studio

## Steps

### 1. Build connector and publish to local Maven repo

```
cd SampleConnectorProject
mvn clean install
```

This shall result in the sample connector being ready to use in Anypoint Studio

### 2. Open sample project in Anypoint Studio

* Open Anypoint Studio
* Use Import->Anypoint Project from file system
* Provide location: `<project root>/SampleMuleProject`
* Click trough the import wizard

<br/>

![alt text](/images/Studio.png "Project in Studio")