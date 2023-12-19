import os

with open(os.path.join(os.path.dirname(os.getcwd()), "input", "InputDay8")) as data:
    lines = data.readlines()
instructions = lines[0].strip()
directions = {}
current_key = 'AAA'
steps = 0
for line in lines[2:]:
    key_value = line.split('=')
    key = key_value[0].strip()
    value = key_value[1].strip()[1:-1].replace(' ', '').split(',')
    directions[key] = tuple(value)


def next_key(dict, currentkey, instruction):
    if instruction == 'L':
        return dict[currentkey][0]
    else:
        return dict[currentkey][1]


while current_key != 'ZZZ':
    for instruction in instructions:
        current_key = next_key(directions, current_key, instruction)
        steps += 1

print(steps)
