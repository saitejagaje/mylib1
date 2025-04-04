def gitDownload(repo)
{
   git "https://github.com/IntelliqDevops/${repo}.git"
}

def buildArtifact()
{
   sh 'mvn package'
}

def deployTomcat(jobname,ipaddress,context)
{
   sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ipaddress}:/var/lib/tomcat9/webapps/${context}.war"
}

def runSelenium(jobname)
{
   sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
