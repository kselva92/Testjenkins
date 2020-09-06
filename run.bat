set projectLocation=/var/lib/jenkins/workspace/PHPSmoke

cd %projectLocation%

set classpath=%projectLocation%\bin;%projectLocation%\lib\*

java org.testng.TestNG %projectLocation%\testng.xml