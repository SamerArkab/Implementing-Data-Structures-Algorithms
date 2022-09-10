# Implementation of a simple Hash Table with put and remove methods

def is_prime(num):
    if num == 1 or num == 0:
        return False
    for i in range(2, num//2):
        if num % i == 0:
            return False
    return True


def get_prime(prime_by_hash_table_size):
    if prime_by_hash_table_size % 2 == 0:
        prime_by_hash_table_size += 1
    while not is_prime(prime_by_hash_table_size):
        prime_by_hash_table_size += 2
    return prime_by_hash_table_size


def hash_method(key):
    m_capacity = get_prime(hash_table_size)
    return key % m_capacity


def put(key, value):
    index = hash_method(key)
    hash_table[index] = [key, value]


def remove_by_key(key):
    index = hash_method(key)
    hash_table[index] = [None]


hash_table_size = int(input("Enter Hash Table size: "))
hash_table = [[None], ] * hash_table_size

put(0, 10)
put(1, 20)
print(hash_table)

remove_by_key(1)
print(hash_table)

put(1, 15)
put(8, 5)
print(hash_table)
