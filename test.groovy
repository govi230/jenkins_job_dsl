job("WebDeploy"){
    authenticationToken("redhat")
    description("Webpage Deploy")
    label("sshAgent")
    scm{
        git{
            remote{
                branch("master")
                github(
                    ownerAndProject = "govi230/okd_training",
                    protocol = "https",
                    host = "github.com"
                )
            }
            extensions{
                relativeTargetDirectory("webpages")
            }
        }
    }
    triggers{
        urlTrigger{

        }
    }
    steps{
        shell{
            command("sudo cp -r webpages/* /var/www/html")
        }
    }

}
