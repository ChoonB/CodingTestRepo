def solution(n):
    answer = 0
    num = bin(n).count("1")
    for i in range(n+1,1000001):
        b_i = bin(i)
        if num == b_i.count("1"):
            answer = i
            break
    
    return answer