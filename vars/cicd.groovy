def download(repo)
{
    git "https://github.com/intelliqittrainings/${repo}"
}
def build()
{
  sh 'mvn package'
}
def deployment(jobname,ipaddress,appname)
{
    sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war   ubuntu@${ip}:/var/lib/tomcat9/webapps/${appname}.war"
}
def selenium(jobname)
{
   sh 'java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar
}
