'''
PROBLEM -----
             |
             |
             |
             .

Your favorite store is having a sale! You pay full price for the most expensive item that you get, but then you get 30% off of everything else in your purchase! How much are you going to save? 
Sales tax is 7%. 
Also, you leave anything below a dollar in your saving as a tip to the seller. If your saving is a round amount, you dont leave any tips.

Task: 
Given the prices of items you want to purchase, determine how much you will save during your shopping! 

Input Format: 
An string of numbers separated by commas that represent the prices for all of the items that you want to purchase (without tax).

Output Format: 
An integer number that represents the total savings that you got for shopping during the sale.

Sample Input: 
100.25,80.99,40.00

Sample Output: 
38
'''

from math import floor

prices = [float(i) + 7/100*float(i) for i in input().split(',')] #taking input, storing the prices in a list in float data type with tax added to each

def discount():
    DISCOUNT = 0
    MAX = max(prices)
    for i,p in enumerate(prices):
        if p != MAX:
            DISCOUNT += 30/100*p
    return DISCOUNT

print(floor(discount()))
