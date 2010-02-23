# Makefile for Artificial Intelligence
# Erik J. Linstead
# Joe Smith
# 02/22/10
 
CC = javac
INT = java
SOURCES := *.java
CLASSDIR := cls
.PHONY: clean

all:
	make build && make run

build:

	$(CC) -d $(CLASSDIR) $(SOURCES) -Xlint:unchecked

prod:
	$(CC) $(CLASSDIR) $(SOURCES)

run:
	$(INT) -classpath $(CLASSDIR) Robot
 
clean:
	rm -f $(CLASSDIR)/*.class

