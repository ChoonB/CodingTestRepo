from collections import Counter

def solution(want, number, discount):
    want_dict = dict(zip(want, number))
    total = len(discount)
    days = 10
    count = 0
    
    for i in range(total-days+1):
        current_window = discount[i:i+days]
        current_count = Counter(current_window)
        
        if all(current_count[item] >= want_dict[item] for item in want_dict):
            count += 1
    
    return count
