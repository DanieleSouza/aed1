JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	NodePosition.java 	\
	Node.java 			\
	Tree.java 			\
	Main.java	

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class