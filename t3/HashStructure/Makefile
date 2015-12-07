JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	SocketPosition.java	\
	Socket.java 		\
	Arm.java 			\
	Structure.java		\
	Main.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class