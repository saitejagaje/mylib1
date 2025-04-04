def gitDownload(repo)
{
   git "https://github.com/IntelliqDevops/${repo}.git"
}

def buildArtifact()
{
   sh 'mvn package'
}

def d(jobname,ip,appname)
{
      sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war   ubuntu@${ip}:/var/lib/tomcat9/webapps/${appname}.war"
}

def runSelenium(jobname)
{
   sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
