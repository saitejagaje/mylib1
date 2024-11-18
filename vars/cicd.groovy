def gitDownload(repo)
{
   git "https://github.com/IntelliqDevops/${repo}.git"
}

def buildArtifact()
{
   sh 'mvn package'
}

def deployment(ipaddress,appname)
{
    deploy adapters: [tomcat9(credentialsId: 'new-credentials', path: '', url: ${ipaddress})], contextPath: /${appname}, war: '**/*.war'
}

def runSelenium(jobname)
{
   sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
