job("WebDeploy"){
    description("Webpage Deploy")
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
    steps{
        shell{
            command("sudo cp -r webpages/* /var/www/html")
        }
    }

}
