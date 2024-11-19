def gitDownload(repo)
{
   git "https://github.com/IntelliqDevops/${repo}.git"
}

def buildArtifact()
{
   sh 'mvn package'
}
def runSelenium(jobname)
{
   sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
