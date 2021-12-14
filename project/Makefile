MWST: MWST.class
	echo Main-class: MWST > Manifest
	jar cvfm MWST Manifest MWST.class DisjointSet.class Edge.class
	rm Manifest
	chmod +x MWST

MWST.class: MWST.java DisjointSet.java Edge.java
	javac -Xlint MWST.java DisjointSet.java Edge.java

clean:
	rm -f MWST MWST.class DisjointSet.class Edge.class