def gitDownload(repo)
{
   git "https://github.com/IntelliqDevops/${repo}.git"
}

def buildArtifact()
{
   sh 'mvn package'
}
def deploy(ip,path)
{
   deploy adapters: [tomcat9(credentialsId: 'new-credentials', path: '', url: 'http://${ip}:8080')], contextPath: ${path}, war: '**/*.war'
}
def runSelenium(jobname)
{
   sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
