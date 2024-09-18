def dfs(numbers, target, current_sum, depth):
    global answer
    if depth == len(numbers):
        if current_sum == target:
            answer += 1
    else:
        dfs(numbers, target, current_sum + numbers[depth], depth + 1)
        dfs(numbers, target, current_sum - numbers[depth], depth + 1)

def solution(numbers, target):
    global answer
    answer = 0
    dfs(numbers, target, 0, 0)
    return answer
