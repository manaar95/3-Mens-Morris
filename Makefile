JFLAGS = -g
JC = javac
RM = rm
PROGRAM_NAME = Assignment2


# Windows (cygwin)
ifeq "$(OS)" "Windows_NT"
	RM=del #rm command for windows powershell
endif

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	$(PROGRAM_NAME).java \
	Smokers.java \
	Semaphore.java \
	AgentAgatha.java   

run: classes clean

classes: $(CLASSES:.java=.class)
	java $(PROGRAM_NAME)

clean:
	$(RM) *.class
