# Makefile for Artificial Intelligence
# Erik J. Linstead
# Joe Smith
# 02/22/10
 
CC = javac
INT = java
SOURCES := *.java
CLASSDIR := cls
OPTS = -Xlint:deprecation -Xlint:unchecked
CLASS := Robot
INPUT := sample.txt
.PHONY: clean

all:
	make clean && make build && make run

build:

	$(CC) -d $(CLASSDIR) $(SOURCES) $(OPTS)

prod:
	$(CC) $(CLASSDIR) $(SOURCES)

run:
	$(INT) -classpath $(CLASSDIR) $(CLASS) $(INPUT)
 
clean:
	rm -f $(CLASSDIR)/*.class

