## Benchmark Result
- benchmarking using while, for, stream foreach and stream foreach ordered
 - tested with java 9
 - Intel® Core™ i7-5500U CPU @ 2.40GHz × 4

### Result
#### HashSet
 - HashSet search WHILE: 32 milliseconds
 - HashSet search FOR: 17 milliseconds
 - HashSet search STREAM_FOREACH: 48 milliseconds
 - HashSet search STREAM_FOREACH_ORDERED: 13 milliseconds
 - HashSet remove WHILE: 15 milliseconds
 - HashSet remove FOR: 8 milliseconds
 - HashSet remove STREAM_FOREACH: 7 milliseconds
 - HashSet remove STREAM_FOREACH_ORDERED: 5 milliseconds

#### LinkedHashSet
 - LinkedHashSet search WHILE: 10 milliseconds
 - LinkedHashSet search FOR: 10 milliseconds
 - LinkedHashSet search STREAM_FOREACH: 18 milliseconds
 - LinkedHashSet search STREAM_FOREACH_ORDERED: 15 milliseconds
 - LinkedHashSet remove WHILE: 20 milliseconds
 - LinkedHashSet remove FOR: 4 milliseconds
 - LinkedHashSet remove STREAM_FOREACH: 10 milliseconds
 - LinkedHashSet remove STREAM_FOREACH_ORDERED: 9 milliseconds

#### TreeSet
 - TreeSet search WHILE: 45 milliseconds
 - TreeSet search FOR: 30 milliseconds
 - TreeSet search STREAM_FOREACH: 35 milliseconds
 - TreeSet search STREAM_FOREACH_ORDERED: 28 milliseconds
 - TreeSet remove WHILE: 42 milliseconds
 - TreeSet remove FOR: 3 milliseconds
 - TreeSet remove STREAM_FOREACH: 4 milliseconds
 - TreeSet remove STREAM_FOREACH_ORDERED: 3 milliseconds

#### ArrayList
 - ArrayList search WHILE: 2723 milliseconds
 - ArrayList search FOR: 2090 milliseconds
 - ArrayList search STREAM_FOREACH: 2105 milliseconds
 - ArrayList search STREAM_FOREACH_ORDERED: 2187 milliseconds
 - ArrayList remove WHILE: 978 milliseconds
 - ArrayList remove FOR: 2 milliseconds
 - ArrayList remove STREAM_FOREACH: 1 milliseconds
 - ArrayList remove STREAM_FOREACH_ORDERED: 2 milliseconds

#### LinkedList
 - LinkedList search WHILE: 5861 milliseconds
 - LinkedList search FOR: 5037 milliseconds
 - LinkedList search STREAM_FOREACH: 5143 milliseconds
 - LinkedList search STREAM_FOREACH_ORDERED: 5378 milliseconds
 - LinkedList remove WHILE: 2682 milliseconds
 - LinkedList remove FOR: 2 milliseconds
 - LinkedList remove STREAM_FOREACH: 1 milliseconds
 - LinkedList remove STREAM_FOREACH_ORDERED: 0 milliseconds

