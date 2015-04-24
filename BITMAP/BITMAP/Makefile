PROJ = bitmap
CC = g++

CFLAGS = -c -g -Wall -I/opt/local/include 
OBJS = $(patsubst %.cpp,%.o,$(wildcard *.cpp))

all: $(PROJ)

$(PROJ): $(OBJS)
	$(CC)  $^ -o $@ $(VAR)

%.o: %.cpp
	$(CC) $(CFLAGS) $< -o $@

%.o: %.cpp %.h
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm -f $(PROJ) $(OBJS) $(TEST_CASES) *.xml

