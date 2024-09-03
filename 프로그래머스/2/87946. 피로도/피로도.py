def solution(k, dungeons):
    visited = [False] * len(dungeons)
    count = 0
    answer = 0
    
    def dfs(k, count):
        nonlocal answer
        for i in range(len(dungeons)):
            if not visited[i] and k >= dungeons[i][0]:
                count += 1
                answer = max(answer, count)
                visited[i] = True
                k -= dungeons[i][1]
                dfs(k, count)
                k += dungeons[i][1]
                visited[i] = False
                count -= 1
    
    dfs(k, count)
    return answer
