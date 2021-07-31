job("Maven JOb"){
    // 'github_repo' variable contains username and reponame
    // Like   '--username--/--reponame--'
    github_repo = "govi230/simple-java-maven-app"
    // Token Value (With the help of this Token Job Can be run remotely with URL)
    job_token = "redhat"
    // 'job_description' contains description about JOB
    job_description = "Maven Build Process"
    // 'display_name' contain Name which will we display on Jenkins Jos Dashboard
    display_name = "Sample Maven Job App"
    // 'scm_target_dir' contains relative directory path from Job Workspace 
    // where GitHub repository will be stored
    scm_target_dir = "maven_app"
    // Maven Installation Name
    maven_nstallation = "maven-3.8.1"


    // Provide Authentication Token
    authenticationToken(job_token)
    // Job Description 
    description(job_description)
    // Display Name
    displayName(display_name)
    // Agent Label where this job will be run
    label("sshAgent")
    scm{
        git{
            remote{
                branch("master")
                github(
                    ownerAndProject = github_repo,
                    protocol = "https",
                    host = "github.com"
                )
            }
            extensions{
                relativeTargetDirectory(scm_target_dir)
            }
        }
    }
    steps{
        maven{
            mavenInstallation(maven_nstallation)
            goals("package")
            rootPOM(scm_target_dir)
        }
    }
    publishers{
        archiveArtifacts{
            pattern(scm_target_dir+"/target/*.jar")
            onlyIfSuccessful()
        }
        jUnitResultArchiver{
            testResults(scm_target_dir+"/target/surefire-reports/*.xml")
        }
    }
}
