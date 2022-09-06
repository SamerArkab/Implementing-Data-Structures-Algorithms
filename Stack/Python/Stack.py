def is_empty(stack_len):
    return len(stack_len) == 0


def is_full(stack_len, stack_size):
    return len(stack_len) >= stack_size


def push(stack_app, new_top, stack_size):
    if is_full(stack_app, stack_size):
        print("Stack is full.")
        return
    stack_app.append(new_top)
    print("Item pushed: " + new_top)


def pop(stack_pop):
    if is_empty(stack_pop):
        print("Stack is empty. ", end='')
        return
    else:
        return stack_pop.pop()


def peek(stack_peek):
    if is_empty(stack_peek):
        print("Stack is empty. ", end='')
        return
    else:
        return stack_peek[-1:]


def print_stack(stack_print):
    print("Print stack: ", end='')
    for i in stack_print:
        print(i + "    ", end='')
    print()


size = int(input("Enter stack size: "))
stack = []

print(is_empty(stack))
print("Item popped: " + str(pop(stack)))
push(stack, str(11), size)
push(stack, str(12), size)
print_stack(stack)
push(stack, str(13), size)
print(is_full(stack, size))

push(stack, str(14), size)
print(is_full(stack, size))

print("Item popped: " + str(pop(stack)))
print("Item popped: " + str(pop(stack)))
push(stack, str(15), size)
print_stack(stack)
push(stack, str(16), size)
print_stack(stack)
print("Peek top item: " + str(peek(stack)))
