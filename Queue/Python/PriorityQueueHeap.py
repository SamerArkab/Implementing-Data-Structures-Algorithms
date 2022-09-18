from queue import PriorityQueue

my_pqh = PriorityQueue()

my_pqh.put((2, 'b'))
my_pqh.put((1, 'a'))
my_pqh.put((4, 'd'))
my_pqh.put((3, 'c'))

print(my_pqh.get())
print(my_pqh.get())
