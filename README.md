# How to use

### Install the archetype to your local maven repository
```
$ mvn clean install
```

### Generate a new project
```
$ mvn archetype:generate -DarchetypeGroupId=org.egg.archetype -DarchetypeArtifactId=egg-archetype -DarchetypeVersion=1.0.0 -DgroupId=org.egg.demo -DartifactId=demo-service -Dversion=1.0.0-SNAPSHOT -DinteractiveMode=false -DarchetypeCatalog=internal -Dpackage=org.egg.demo
```
