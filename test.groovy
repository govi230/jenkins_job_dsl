job("WebDeploy"){
    github_repo = "govi230/okd_training"
    authenticationToken("redhat")
    description("Webpage Deploy")
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
