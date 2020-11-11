# Instructions
This is a small examination to evaluate your skills regarding programming with java. After you set up your system you should be able to run the test application within the zip File.
You will finde several TODOs within the code and it will take you about **2 to 3 hours** to complete the tasks described. Don`t worry if you need a little more time to complete it or if your are not able to solve every TODO.

When you are finished with your work send us your code back for evaluation.

Have fun! 

## Install jdk 8 
If you have already a jdk 8 installed in your computer ignore this part. 
You can install a **Jdk 8** from Oracle, Zulu or you can decided by yourself which one you like the most.
We use currently for our projects **Zulu**. [Follow this documentation if you opt to install it](https://docs.azul.com/zulu/zuludocs/ZuluUserGuide/InstallingZulu/InstallZulu.htm)

## Install a java IDE
If you have already one installed, ignore this part. 
Otherwise we can recomend [Eclipse IDE for Enterprise Java Developers](https://www.eclipse.org/downloads/packages/release/2020-03/r/eclipse-ide-enterprise-java-developers-includes-incubating-components)

Please notice that you need to set up the jdk 8 and a maven in you IDE.


## Configure the TestApp project in your IDE

Unzip the files into a folder and import it as maven project in you IDE.
Please perform a maven install to verify that everything is working.

# Run the Program

If everything compiles properly you can run just execute the __com.carano.testapp.Application__ as a java main program.
It will start an spring boot server under port 8080 with a Rest service (methods are configure in __ZipController__ ).
Additionally you have an swagger-ui api where you can test the service. Just call [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

Here a small video how to use the swagger-ui for your tests:  [docs/swagger-ui.webm](docs/swagger-ui.webm)

It is just a simple rest service to be able to retrieve zip codes and cities.

# TODOs

There are several places in code marked as **// TODO** that you are required to do.
You can start in this order:
 * ZipController
 * ZipServiceFromFileImpl
 * ZipServiceFromFileImplTest
 
If you can not finish everything, there is no problem, but best if you can perform the tasks in the described order.
 
 
