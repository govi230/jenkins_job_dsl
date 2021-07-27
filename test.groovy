job("WebDeploy"){
    description("Webpage Deploy")
    scm{
        github(
            ownerAndProject = "govi230/okd_training",
            branch = "master",
            protocol = "https"
        )
    }
    steps{
        shell{
            command("cp -r okd_training/* /var/www/html/")
        }
    }

}