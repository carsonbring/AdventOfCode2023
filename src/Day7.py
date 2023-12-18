from functools import cmp_to_key
import os

filepath = "./input/InputDay7"
card_order = ["A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"]
hand_order = ["five", "four", "full", "three", "two", "one", "high"]
hands = []
with open(os.path.join(os.path.dirname(os.getcwd()), "input", "InputDay7")) as data:
    lines = data.readlines()
for line in lines:
    vals = line.split()
    hands.append([vals[0], vals[1]])


def cmp_hand(h1, h2):
    hand1 = get_hand(h1[0])
    hand2 = get_hand(h2[0])
    if hand_order.index(hand1) < hand_order.index(hand2):
        return 1
    if hand_order.index(hand1) > hand_order.index(hand2):
        return -1

    return find_highest(h1[0], h2[0])


def get_hand(hand):
    totals = []
    for rank in card_order:
        total = 0
        for card in hand:
            if card == rank:
                total += 1
        if total != 0:
            totals.append(total)
    if totals.count(5) != 0:
        return "five"
    if totals.count(4) != 0:
        return "four"
    if totals.count(3) != 0 and totals.count(2) != 0:
        return "full"
    if totals.count(3) != 0:
        return "three"
    # two pairs
    if totals.count(2) > 1:
        return "two"
    if totals.count(2) > 0:
        return "one"
    else:
        return "high"


def find_highest(hand1, hand2):
    for i in range(len(hand1)):
        if card_order.index(hand1[i]) < card_order.index(hand2[i]):
            return 1
        if card_order.index(hand1[i]) > card_order.index(hand2[i]):
            return -1


hands.sort(key=cmp_to_key(cmp_hand))
totalwinnings = 0
rank = 1
for i in range(len(hands)):

    totalwinnings = totalwinnings + rank * int(hands[i][1])
    rank += 1
print("Part 1:")
print(totalwinnings)
