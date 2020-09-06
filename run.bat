java -cp bin;lib/* org.testng.TestNG testng.xml


set projectLocation=C:\Users\Surukam\neweclipse-workspace\PHPSmoke

cd %projectLocation%

set classpath=%projectLocation%\bin;%projectLocation%\lib\*

java org.testng.TestNG testng.xml