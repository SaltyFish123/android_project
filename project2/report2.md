## Creating a repository and adding a remote

At first, I create a local repository on my computer with the following commands.

```sh
mkdir android_project
cd android_project 
git init
```

Then I create, stage and commit the files.

```sh
git add -A
git commit -m "create the README.md"
```

Then I create a remote repository on github and connect it with the local repository. Then I push the local one to the github.

```sh
git remote add origin git@github.com:SaltyFish123/android_project.git
git push -u origin master
```

And then we can see the remote repository is up-to-date now.

![image](/home/joey/Pictures/set-up-github.png)

