job("WebDeploy"){
    // 'github_repo' variable contains username and reponame
    // Like   '--username--/--reponame--'
    github_repo = "govi230/okd_training"
    
    // Token Value (With the help of this Token Job Can be run remotely with URL)
    job_token = "redhat"
    
    // 'job_description' contains description about JOB
    job_description = "Web Deployment"

    // Provide Authentication Token
    authenticationToken(job_token)
    // Job Description 
    description(job_description)
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
                relativeTargetDirectory("webpages")
            }
        }
    }
    steps{
        shell{
            command("sudo cp -r webpages/* /var/www/html")
        }
    }

}
