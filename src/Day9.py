import os

with open(os.path.join(os.path.dirname(os.getcwd()), "input", "InputDay9")) as data:
    lines = data.readlines()
def part1():
    pyramids = []
    sum = 0
    for line in lines:
        collection = []
        numbers = [int(num) for num in line.split()]
        collection.append(numbers)
        current_length = len(numbers) - 1
        current_list = numbers
        while not all(element == 0 for element in current_list):
            new_list = []
            for i in range(len(current_list) - 1):
                new_list.append(current_list[i + 1] - current_list[i])
            collection.append(new_list)
            current_list = new_list
        modifier = 0
        for list in collection[::-1]:
            list.append(list[-1] + modifier)
            modifier = list[-1]

        sum += collection[0][-1]

    print(sum)

print("Part 1:")
part1()






