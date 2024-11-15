def download(repo)
{
    git "https://github.com/intelliqittrainings/${repo}"
}
def build()
{
  sh 'mvn package'
}
def deployment(ipaddress,appname)
{
    deploy adapters: [tomcat9(credentialsId: 'new-credentials', path: '', url: '${ipaddress}')], contextPath: '/${appname}', war: '**/*.war'
}
def selenium(jobname)
{
   sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
