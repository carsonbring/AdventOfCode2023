import os
from math import lcm
with open(os.path.join(os.path.dirname(os.getcwd()), "input", "InputDay8")) as data:
    lines = data.readlines()
instructions = lines[0].strip()
graph = {}
steps = 0
for line in lines[2:]:
    key_value = line.split('=')
    key = key_value[0].strip()
    value = key_value[1].strip()[1:-1].replace(' ', '').split(',')
    graph[key] = tuple(value)

starting_nodes = [node for node in graph if node[2] == 'A']
steps_until = [0 for _ in range(len(starting_nodes))]

for i in range(len(starting_nodes)):
    steps = 0
    while starting_nodes[i][2] != 'Z':
        for instruction in instructions:
            node = starting_nodes[i]
            starting_nodes[i] = graph[node][0 if instruction == 'L' else 1]
            steps += 1
        steps_until[i] = steps
print(lcm(*steps_until))

