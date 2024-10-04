from collections import deque
def solution(maps):
    answer = 0
    n = len(maps)
    m = len(maps[0])
    x_move = [1,0,-1,0]
    y_move = [0,1,0,-1]
    visited = [[False for _ in range(m)] for _ in range(n)]
    
    visited[0][0] = True
    q = deque()
    q.append([0,0,0])
    x = 0
    y = 0
    while q:
        current = q.popleft()
        c_x, c_y, c_t = current
        
        if(c_x==n-1 and c_y==m-1): 
            return c_t+1
        
        for i in range(4):
            new_x = c_x + x_move[i]
            new_y = c_y + y_move[i]
            if new_x<0 or new_x>= n or new_y<0 or new_y>=m: continue
            if visited[new_x][new_y] or maps[new_x][new_y]==0: continue
            q.append([new_x, new_y, c_t+1])
            visited[new_x][new_y] = True
    
    return -1