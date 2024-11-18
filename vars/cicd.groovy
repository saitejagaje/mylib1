def download(repo)
{
    git "https://github.com/intelliqittrainings/${repo}"
}
def build()
{
  sh '''mvn package'''
}

def selenium(jobname)
{
   sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
