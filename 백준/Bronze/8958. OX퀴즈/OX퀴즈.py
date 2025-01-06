def calculate_point(answers: str):
    l = len(answers)
    point = 0
    continuous_num = 0
    if l==1:
        if answers == "O":
            return 1
        else: 
            return 0
    
    if answers[0] == "O":
        point += 1
        continuous_num += 1
    
    for i in range(1, l):
        if answers[i] == "O":
            continuous_num += 1
            point += continuous_num
        else:
            continuous_num = 0
    
    return point


n = int(input())

for _ in range(n):
    answers = input()
    num = calculate_point(answers)
    print(num)