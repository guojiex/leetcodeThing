PROJ = bitmap
CC = g++

CFLAGS = -c -g -Wall -I/opt/local/include 
LDFLAGS = -L/opt/local/lib 
LIBS = -ldl
OBJS = $(patsubst %.cpp,%.o,$(wildcard *.cpp))

all: $(PROJ)

$(PROJ): $(OBJS)
	$(CC) $(LDFLAGS) $^ -o $@ $(LIBS) $(VAR)

%.o: %.cpp
	$(CC) $(CFLAGS) $< -o $@

%.o: %.cpp %.h
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm -f $(PROJ) $(OBJS) $(TEST_CASES) *.xml

