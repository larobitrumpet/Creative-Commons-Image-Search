JCC = javac
JFLAGS = -g
JVM = java
CCP = -cp .:gson-1.2.4.jar:junit-4.12.jar:javafxsvg-1.3.0.jar:batik-anim-1.8.jar:batik-awt-util-1.8.jar:batik-bridge-1.8.jar:batik-css-1.8.jar:batik-dom-1.8.jar:batik-ext-1.8.jar:batik-gvt-1.8.jar:batik-parser-1.8.jar:batik-script-1.8.jar:batik-svg-dom-1.8.jar:batik-svggen-1.8.jar:batik-transcoder-1.8.jar:batik-util-1.8.jar:batik-xml-1.8.jar:xml-apis-1.3.04.jar:xml-apis-ext-1.3.04.jar:xmlgraphics-commons-2.1.jar
RCP = -cp .:gson-2.2.4.jar:junit-4.12.jar:hamcrest-core-1.3.jar:javafxsvg-1.3.0.jar:batik-anim-1.8.jar:batik-awt-util-1.8.jar:batik-bridge-1.8.jar:batik-css-1.8.jar:batik-dom-1.8.jar:batik-ext-1.8.jar:batik-gvt-1.8.jar:batik-parser-1.8.jar:batik-script-1.8.jar:batik-svg-dom-1.8.jar:batik-svggen-1.8.jar:batik-transcoder-1.8.jar:batik-util-1.8.jar:batik-xml-1.8.jar:xml-apis-1.3.04.jar:xml-apis-ext-1.3.04.jar:xmlgraphics-commons-2.1.jar


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
