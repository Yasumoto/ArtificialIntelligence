# Makefile for Artificial Intelligence
# Erik J. Linstead
# Joe Smith
# 02/22/10
 
CC = javac
SOURCES := *.java
CLASSDIR := cls
.PHONY: clean

all:
	$(CC) -d $(CLASSDIR) $(SOURCES) -Xlint:unchecked

real:
	$(CC) $(CLASSDIR) $(SOURCES)
 
clean:
	rm -f $(CLASSDIR)/*.class

