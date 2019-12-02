
# Project Management Software by project-group-12
## Downloading the repository  
To get the repository on your computer:  
1. Start Git Bash in the folder on your computer where you want to download the repository.  
2. Clone the repo with the following command  
	`git clone https://git.ita.chalmers.se/courses/dit092/project-group-12.git`  
3. You will be prompted for your username and password, fill those in as requested.
4. Now type `cd project-group-12/`
5. If we are working in a branch, use `git checkout name-of-branch` 
    For now, we are using the workshop branch
6. Done! You should now have the repository downloaded and the correct branch ckecked out  
  
## Creating an Eclipse-project  
To create an Eclipse-project in the repository go through the following steps:  
1. Start Eclipse  
2. Navigate to File\New\Java-project  
3. Name your project dit092  
4. Untick Use default location  
5. Press Browse... to pick your repository's location manually  
6. Navigate to the folder where you have your repository  
	Example: C:\Users\username\git\project-group-12  
	Make sure it is the root-folder of your repository, i.e. the one named project-group-12  
	Leave the other fields as is  
7. Press Finish  
8. In Git Bash, do a `git status` in the repository to check that the .gitignore file is working as intended
	There should be no files for you to commit at this point
	If there is, update .gitignore with those files or inform the group of this
9. The project should now be open in Eclipse and ready for you to work on  
Make sure to put code in the src/dit092-package  
  
## Useful git commands  
`git pull`  
`git status`  
`git commit -m "Your message here."`  
`git push`  
`git checkout name-of-branch`  

