def newDownload(repo)
{
   git "https://github.com/intelliqDevops/${repo}"
}

def newBuild()
{
   sh 'mvn package'
}

def newDeploy(jobname,ip,appname)
{
    sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war   ubuntu@${ip}:/var/lib/tomcat10/webapps/${appname}.war"
}

def runSelenium(jobname)
{
sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
