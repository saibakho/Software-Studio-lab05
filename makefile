all: *.java
	javac *.java
	java Menu
clean: *.class
	del *.class