def solution(s):
    count_zero = 0
    count_loop = 0
    b = s
    while not b == '1':
        count_loop += 1
        count_zero += b.count("0")
        b = b.replace("0", "")
        b = bin(len(b))[2:]
    
    answer = [count_loop, count_zero]
    return answer