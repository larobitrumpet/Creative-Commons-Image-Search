JCC = javac
JFLAGS = -g
JVM = java
GSON = -cp .:gson-2.2.4.jar
JUNITC = -cp .:junit-4.12.jar
JUNITR = -cp .:junit-4.12.jar:hamcrest-core-1.3.jar

default: CCISMain.class CCISController.class CCISModel.class ImageResult.class GenericList.class Boxcar.class SingleLinkList.class

CCISMain.class: CCISMain.java
	$(JCC) $(JFLAGS) $(GSON) CCISMain.java

CCISController.class: CCISController.java
	$(JCC) $(JFLAGS) $(GSON) $(JUNITC) CCISController.java

CCISModel.class: CCISModel.java
	$(JCC) $(JFLAGS) $(GSON) $(JUNITC) CCISModel.java

ImageResult.class: ImageResult.java
	$(JCC) $(JFLAGS) $(GSON) $(JUNITC) ImageResult.java

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
	$(JVM) $(GSON) CCISMain

jar:
	jar cvmf manifest.txt CCIS.jar *.java *.class *.fxml cc_images makefile gson-2.2.4.jar
