commands to initialize a repository on local and push it to github
- initialize git by "git init" command - this creates a .git directory with all needed files
- create new files and add it to staging using "git add ." - adds all the files to staging
- commit the changes using "git commit" command with -m switch 
- configure remote using "git remote add origin https://github.com/okuswaha/product-manager.git"
- check if remote exits using "git remote -v" command
- push commit to remote uisng "git push -u origin master" 

command to initialize a maven project 

mvn archetype:generate -DgroupId={project-packaging} -DartifactId={project-name} -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

C:\MY_GIT\>mvn archetype:generate -DgroupId=com.prakash -DartifactId=product-manager -DarchetypeArtifactId=maven-archetype-quickstart -Dint
eractiveMode=false

caution : dont miss ":" or "-"

- Maven configuration :  add maven dependency --> io.dropwizard:dropwizard-core:1.0.5
- Define a configuration class : configuration.yaml in project root , and a class that extends Configuration class - maps properties in yaml file
- Define an application class : new productApplication class that extends Application<ProductConfiguration>
- Define a representation class : new Representaion class
- Define a resource class : new Resource class
- Registring a resource : register Resource in Application
- Build Application : add maven-shade-plugin and check if the maven-compiler-plugin is set to correct version as java runtime
- Running an Application : java -jar target/product-manager-1.0-SNAPSHOT.jar server configuration.yml
- Application Test URL :  http://localhost:8080/product

How to use Jenkinsfile

How to use Dockerfile
cd to directoy with Dockerfile
run the following command 
>docker build -t "product-manager:1.0" .
this will build and image 
REPOSITORY           TAG       IMAGE ID       CREATED             SIZE
product-manager      1.0       212f6fdfef21   48 seconds ago      671MB

now to run :

docker debugging attach shell
>docker run -it product-manager:1.0 /bin/sh

run 
>docker run product-manager:1.0

attach a tty 
>docker exec -it wonderful_tharp /bin/sh

kill container 
docker kill d44eccd7fa9b

docker expose port 
>docker run -d -p 9081:9081 product-manager:1.0
>
this error mean problem with line ending
standard_init_linux.go:211: exec user process caused "no such file or directory"

create a repsoitory in dockerhub
tag docker image with the name of the repo
>docker tag product-manager:1.0 okuswaha/product-manager:1.0

>docker login -u username -p password
>docker push okuswaha/product-manager:1.0
