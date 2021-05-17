JCC = javac
JFLAGS = -g
JVM = java
CCP = -cp .:gson-2.2.4.jar:junit-4.12.jar
RCP = -cp .:gson-2.2.4.jar:junit-4.12.jar:hamcrest-core-1.3.jar

default: CCISMain.class CCISController.class CCISMoreController.class CCISModel.class ImageResult.class GenericList.class Boxcar.class SingleLinkList.class

CCISMain.class: CCISMain.java
	$(JCC) $(JFLAGS) $(CCP) CCISMain.java

CCISController.class: CCISController.java
	$(JCC) $(JFLAGS) $(CCP) CCISController.java

CCISMoreController.class: CCISMoreController.java
	$(JCC) $(JFLAGS) $(CCP) CCISMoreController.java

CCISModel.class: CCISModel.java
	$(JCC) $(JFLAGS) $(CCP) CCISModel.java

ImageResult.class: ImageResult.java
	$(JCC) $(JFLAGS) $(CCP) ImageResult.java

GenericList.class: GenericList.java
	$(JCC) $(JFLAGS) GenericList.java

Boxcar.class: Boxcar.java
	$(JCC) $(JFLAGS) Boxcar.java

SingleLinkList.class: SingleLinkList.java
	$(JCC) $(JFLAGS) SingleLinkList.java

clean:
	$(RM) *.class
	$(RM) CCIS.jar

run:
	$(JVM) $(RCP) CCISMain

jar:
	jar cvmf manifest.txt CCIS.jar *.java *.class *.fxml cc_images makefile gson-2.2.4.jar
