import  config.*

job("WebDeploy"){
    // Provide Authentication Token
    authenticationToken(config.job_token)
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
