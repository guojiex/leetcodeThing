TARGET : main
OBJS = main.o
CC = g++
main.o : main.cpp trieNode.h trieTree.h
#trieNode.o : trieNode.h
#trieTree.o : trieTree.h
main : $(OBJS)
	$(CC) -o main $(OBJS)
	rm -f *.o
clean:
	rm -f main *.o

