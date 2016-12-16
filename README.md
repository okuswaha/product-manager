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